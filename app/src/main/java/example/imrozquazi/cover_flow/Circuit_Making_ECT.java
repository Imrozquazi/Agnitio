package example.imrozquazi.cover_flow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Circuit_Making_ECT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuit__making__ect);


        Animation a = AnimationUtils.loadAnimation(this,R.anim.viewanim);
        CardView v1 = (CardView)findViewById(R.id.c1_ECT);
        CardView v2 = (CardView)findViewById(R.id.c2_ECT);
        CardView v3 = (CardView)findViewById(R.id.c3_ECT);
        CardView v4 = (CardView)findViewById(R.id.c4_ECT);
        CardView v5 = (CardView)findViewById(R.id.c5_ECT);



        v1.startAnimation(a);
        v2.startAnimation(a);
        v3.startAnimation(a);
        v4.startAnimation(a);
        v5.startAnimation(a);
    }
}
