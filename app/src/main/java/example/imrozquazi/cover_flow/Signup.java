package example.imrozquazi.cover_flow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.transition.Transition;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    private AutoCompleteTextView mName,mEmail,mContact,mPass;
    private Button mbtnSignup;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private ProgressDialog mProSignUp;
    private String name;
    private String email;
    private String con;
    private String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.signup_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        //progressbar
        mProSignUp=new ProgressDialog(this);

        //linking java to xml
        mName = (AutoCompleteTextView) findViewById(R.id.UserName);
        mEmail = (AutoCompleteTextView) findViewById(R.id.signup_email);
        mContact = (AutoCompleteTextView) findViewById(R.id.signup_contact);
        mPass = (AutoCompleteTextView) findViewById(R.id.signup_password);

        //firebase linking
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        mbtnSignup= (Button) findViewById(R.id.btn_signup);

        mbtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mProSignUp.setTitle("Registering User");
                mProSignUp.setMessage("Please wait while we create your account");
                mProSignUp.setCanceledOnTouchOutside(false);
                mProSignUp.show();

                signup();
            }
        });
    }

    private void signup() {

        //fetching details
        name=mName.getText().toString();
        email=mEmail.getText().toString();
        con=mContact.getText().toString();
        pass=mPass.getText().toString();

        //make a map to add it to database
        final Map<String,String> datamap=new HashMap<String, String>();
        datamap.put("Name",name);
        datamap.put("Email",email);
        datamap.put("Contact",con);
        


        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                    String uid=user.getUid();
                    mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);

                    mDatabase.setValue(datamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful())
                            {
                                mProSignUp.dismiss();
                                Intent siginupIntent = new Intent(Signup.this,Bottom_NavBar.class);
                                siginupIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(siginupIntent);
                                //startActivity(new Intent(Signup.this,Homescreen.class));
                            }
                            else {
                                mProSignUp.dismiss();
                                Toast.makeText(getApplicationContext(),"Oopps...!!...Something went wrong",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }

    void login(View v)
    {
        startActivity(new Intent(this,Login.class));
    }
}
