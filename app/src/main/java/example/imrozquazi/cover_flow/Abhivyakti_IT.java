package example.imrozquazi.cover_flow;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Abhivyakti_IT extends AppCompatActivity {

    private Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhiyakti__it);

        Animation a = AnimationUtils.loadAnimation(this,R.anim.viewanim);
        CardView v1 = (CardView)findViewById(R.id.c1_IT);
        CardView v2 = (CardView)findViewById(R.id.c2_IT);
        CardView v3 = (CardView)findViewById(R.id.c3_IT);
        CardView v4 = (CardView)findViewById(R.id.c4_IT);
        CardView v5 = (CardView)findViewById(R.id.c5_IT);



        v1.startAnimation(a);
        v2.startAnimation(a);
        v3.startAnimation(a);
        v4.startAnimation(a);
        v5.startAnimation(a);

        mBtn = (Button) findViewById(R.id.button_event_2_it);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataEntry();
            }
        });
    }


    private void DataEntry() {
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String email=user.getEmail();
        String uid=user.getUid();
        //Toast.makeText(getApplicationContext(),""+email,Toast.LENGTH_LONG).show();

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("IT").child("Abhivyakti").child(uid);

        Map<String, String> data=new HashMap<String,String>();
        data.put("Email",email);
        data.put("Contact",StudentInfo.getContact());
        mDatabase.setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Registered ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
