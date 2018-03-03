package example.imrozquazi.cover_flow;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity {

    private FeatureCoverFlow coverFlow;

    private EventAdapter eventAdapter;

    private List<Event> eventList  = new ArrayList<>();
    private TextSwitcher mTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initData();



        mTitle = (TextSwitcher)findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView txt = (TextView) inflater.inflate((R.layout.layout_title),null);
                txt.setTextColor(Color.BLACK);
                txt.setTextSize(40);

                return txt;

            }
        });

        Animation in = AnimationUtils.loadAnimation(this,R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_bottom);

        mTitle.setAnimation(in);
        mTitle.setAnimation(out);


        //

        eventAdapter = new EventAdapter(eventList,this);
        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        coverFlow.setAdapter(eventAdapter);

        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(eventList.get(position).getName());


            }

            @Override
            public void onScrolling() {

            }
        });


        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Intent in = new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(in);

                }
                if(position == 1)
                {
                    Intent in = new Intent(getApplicationContext(),Main3Activity.class);
                    startActivity(in);
                }
            }
        });


        Animation a = AnimationUtils.loadAnimation(this, R.anim.textanim);
        a.reset();
        TextView tv = (TextView) findViewById(R.id.txtanim);
        tv.clearAnimation();
        tv.startAnimation(a);

    }

    private void initData()
    {


        eventList.add(new Event("Event 1","https://www.internationalstudentinsurance.com/blog/wp-content/uploads/2014/07/487540655-Converted.png"));
        eventList.add(new Event("Event 2","http://anurag.edu.in/wp-content/uploads/2012/quiz.jpg"));
        eventList.add(new Event("Event 3","https://res.cloudinary.com/teepublic/image/private/s--91AeMXfq--/t_Preview/b_rgb:262c3a,c_limit,f_auto,h_313,q_90,w_313/v1496756374/production/designs/1649485_1"));
        eventList.add(new Event("Event 4","https://bookboon.com/thumbnail/720/47f230d1-2d56-4cb9-9d04-a0f600b34b87/495eed07-fa5c-40b4-9667-a5d400e1a9ca/c-1-introduction-to-programming-and-the-c-language.jpg"));

    }

    void Circlemenu(View v)
    {
        Intent in = new Intent(getApplicationContext(),Floatingmenu.class);
        startActivity(in);
    }



}
