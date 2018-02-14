package example.imrozquazi.cover_flow;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    FirebaseUser user;
    Dialog mydialog;
    Button mbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mydialog = new Dialog(this);
        Animation a = AnimationUtils.loadAnimation(this,R.anim.viewanim);
        View v1 = (View)findViewById(R.id.v1);
        View v2 = (View)findViewById(R.id.v2);
        v1.startAnimation(a);
        v2.startAnimation(a);

        mAuth=FirebaseAuth.getInstance();
       mbook = (Button)findViewById(R.id.book);

        mbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataEntry();
            }
        });

    }

    private void DataEntry() {
        user=FirebaseAuth.getInstance().getCurrentUser();

        String email=user.getEmail();

        mDatabase= FirebaseDatabase.getInstance().getReference("Virtual");

        Map<String, String> data=new HashMap<String,String>();
        data.put("Email:",email);
        mDatabase.push().setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"eRROR",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


   /*public void Showpopup(View v)
    {


        mydialog.setContentView(R.layout.activity_popup_);


        mydialog.show();
    }*/
}
