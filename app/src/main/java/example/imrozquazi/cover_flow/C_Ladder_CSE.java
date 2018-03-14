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

public class C_Ladder_CSE extends AppCompatActivity {

    private Button mbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cladder_cse);

        Animation a = AnimationUtils.loadAnimation(this,R.anim.viewanim);
        CardView v1 = (CardView)findViewById(R.id.c1_cse);
        CardView v2 = (CardView)findViewById(R.id.c2_cse);
        CardView v3 = (CardView)findViewById(R.id.c3_cse);
        CardView v4 = (CardView)findViewById(R.id.c4_cse);

        v1.startAnimation(a);
        v2.startAnimation(a);
        v3.startAnimation(a);
        v4.startAnimation(a);

        mbtn = (Button) findViewById(R.id.button_event_2_cse);

        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplication(),"Clicked",Toast.LENGTH_LONG).show();
                DataEntry();

            }
        });
    }


    private void DataEntry() {
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String email=user.getEmail();
        String uid=user.getUid();
        //Toast.makeText(getApplicationContext(),""+email,Toast.LENGTH_LONG).show();

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("CSE").child("C-Ladder").child(uid);

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
