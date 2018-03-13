package example.imrozquazi.cover_flow;

import android.animation.ValueAnimator;
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
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

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
        Button bt = (Button) findViewById(R.id.cli);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),Signup.class));

            }
        });




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
                mProLogin.setMessage("Please wait while we check your credentials");
                mProLogin.setCanceledOnTouchOutside(false);
                mProLogin.show();



                signin();
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
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
                    Intent loginIntent= new Intent(Login.this,Bottom_NavBar.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(loginIntent);
                    //startActivity(new Intent(Login.this,Bottom_NavBar.class));
                    //imroz
                    //chutiya github
                    //Correct

                }
                else {
                    mProLogin.dismiss();
                    Toast.makeText(getApplication(),"UserName Or Password Incorrect",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void Reset(View v)
    {
        String user = mUser.getText().toString();
        if(user == "")
        {
            Toast.makeText(getApplicationContext(),"Enter your email in username",Toast.LENGTH_LONG).show();
        }
        else {

            mAuth.sendPasswordResetEmail(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(),"Password Reset Link has been send to your mail address",Toast.LENGTH_LONG).show();
                }
            });
        }
    }

}
