package example.imrozquazi.cover_flow;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
 // java.util.concurrent.TimeUnit;

public class Intro extends AppCompatActivity {
    LinearLayout l1, l2;
    Animation uptodown, downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

       // l1 = (LinearLayout) findViewById(R.id.l1);


       ///// uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
      //  l1.setAnimation(uptodown);

        final LottieAnimationView animationView = (LottieAnimationView)findViewById(R.id.animation_view3);

        


// CSE Animation
// Custom animation speed or duration.
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f)
                .setDuration(0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animationView.setProgress((Float)animation.getAnimatedValue());
            }
        });
        animator.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i=new Intent(Intro.this,WelcomeActivity.class);
                startActivity(i);
                finish();
            }
        }, 2900);


    }
}