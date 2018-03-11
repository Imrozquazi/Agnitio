package example.imrozquazi.cover_flow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Event_2_CSE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_2_cse);

        Animation a = AnimationUtils.loadAnimation(this,R.anim.viewanim);
        CardView v1 = (CardView)findViewById(R.id.c1_cse);
        CardView v2 = (CardView)findViewById(R.id.c2_cse);
        CardView v3 = (CardView)findViewById(R.id.c3_cse);
        CardView v4 = (CardView)findViewById(R.id.c4_cse);

        v1.startAnimation(a);
        v2.startAnimation(a);
        v3.startAnimation(a);
        v4.startAnimation(a);
    }
}
