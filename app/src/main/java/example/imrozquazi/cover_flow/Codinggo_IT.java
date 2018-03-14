package example.imrozquazi.cover_flow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Codinggo_IT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codinggo__it);

        Animation a = AnimationUtils.loadAnimation(this,R.anim.viewanim);
        CardView v1 = (CardView)findViewById(R.id.c1_IT);
        CardView v2 = (CardView)findViewById(R.id.c2_IT);
        CardView v3 = (CardView)findViewById(R.id.c3_it);
        CardView v4 = (CardView)findViewById(R.id.c4_it);


        v1.startAnimation(a);
        v2.startAnimation(a);
        v3.startAnimation(a);
        v4.startAnimation(a);
    }

}
