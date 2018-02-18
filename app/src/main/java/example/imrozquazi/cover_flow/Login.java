package example.imrozquazi.cover_flow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private AutoCompleteTextView mUser,mPass;
    private Button mlogin;
    private ProgressDialog mProLogin;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.login_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        mProLogin= new ProgressDialog(this);
        //linking java to xml
        mUser= (AutoCompleteTextView) findViewById(R.id.login_user);
        mPass= (AutoCompleteTextView) findViewById(R.id.login_pass);
        mlogin=(Button) findViewById(R.id.btnsignuplogin);

        //FIREBASE
        mAuth= FirebaseAuth.getInstance();


        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mProLogin.setTitle("Logging In");
                mProLogin.setMessage("Please wait while we check yout credentials");
                mProLogin.setCanceledOnTouchOutside(false);
                mProLogin.show();


                signin();
            }
        });
    }

    private void signin() {

        String user=mUser.getText().toString();
        String pass=mPass.getText().toString();

        mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    mProLogin.dismiss();
                    startActivity(new Intent(Login.this,Homescreen.class));

                }
                else {
                    mProLogin.dismiss();
                    Toast.makeText(getApplication(),"Unsuccessful",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    void signup(View v)
    {
        startActivity(new Intent(this,Signup.class));
    }
}
