package example.imrozquazi.cover_flow;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;


public class fragment_home extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Animation anima;

    ViewPager imagesliderhome;

    RelativeLayout r1;

    CardView c;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);




        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_home, container, false);

        c = (CardView)v.findViewById(R.id.c1);
        r1= (RelativeLayout)v.findViewById(R.id.r1);




        r1.setOnClickListener(this);


        final LottieAnimationView animationView = (LottieAnimationView)v.findViewById(R.id.animation_view);


// CSE Animation
// Custom animation speed or duration.
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f)
                .setDuration(60000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animationView.setProgress((Float) animation.getAnimatedValue());
            }
        });
        animator.start();

        //  animationView.cancelAnimation();

//custom color
       /* PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.LIGHTEN);
        animationView.addColorFilter(colorFilter);
        animationView.addColorFilterToLayer("hello_layer", colorFilter);
        animationView.addColorFilterToContent("hello_layer", "hello", colorFilter);
        // animationView.clearColorFilters();*/

        return  v;
       // return inflater.inflate(R.layout.fragment_fragment_home, container, false);




    }

    @Override
    public void onClick(View v)
    {

        startActivity(new Intent(getActivity(),MainActivity.class));
    }

}
