package example.imrozquazi.cover_flow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Auto_CAD_Desgin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto__cad__desgin);


        Animation a = AnimationUtils.loadAnimation(this,R.anim.viewanim);
        CardView v1 = (CardView)findViewById(R.id.c1_Mech);
        CardView v2 = (CardView)findViewById(R.id.c2_Mech);
        CardView v3 = (CardView)findViewById(R.id.c3_Mech);
        CardView v4 = (CardView)findViewById(R.id.c4_Mech);
        CardView v5 = (CardView)findViewById(R.id.c5_Mech);



        v1.startAnimation(a);
        v2.startAnimation(a);
        v3.startAnimation(a);
        v4.startAnimation(a);
        v5.startAnimation(a);
    }
}
