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

public class ECT_EVENTS_MAIN extends AppCompatActivity {

    private FeatureCoverFlow coverFlow_ECT;

    private ECT_EVENT_ADAPTER ECTEVENTADAPTER;

    private List<ECT_EVENT_1> ECTEvent1List = new ArrayList<>();
    private TextSwitcher mTitle_ECT;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ect__events__main);


        initData();



        mTitle_ECT = (TextSwitcher)findViewById(R.id.title_ECT);
        mTitle_ECT.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(ECT_EVENTS_MAIN.this);
                TextView txt = (TextView) inflater.inflate((R.layout.layout_title),null);
                txt.setTextColor(Color.BLACK);
                txt.setTextSize(40);

                return txt;

            }
        });

        Animation in = AnimationUtils.loadAnimation(this,R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_bottom);

        mTitle_ECT.setAnimation(in);
        mTitle_ECT.setAnimation(out);




        ECTEVENTADAPTER = new ECT_EVENT_ADAPTER(ECTEvent1List,this);
        coverFlow_ECT = (FeatureCoverFlow) findViewById(R.id.coverflow_ECT);
        coverFlow_ECT.setAdapter(ECTEVENTADAPTER);

        coverFlow_ECT.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle_ECT.setText(ECTEvent1List.get(position).getName());


            }

            @Override
            public void onScrolling() {

            }
        });


        coverFlow_ECT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Intent in = new Intent(getApplicationContext(),CodeRelay_CSE.class);
                    startActivity(in);

                }
                if(position == 1)
                {
                    Intent in = new Intent(getApplicationContext(),C_Ladder_CSE.class);
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


        ECTEvent1List.add(new ECT_EVENT_1("Circuit Making","https://www.internationalstudentinsurance.com/blog/wp-content/uploads/2014/07/487540655-Converted.png"));
        ECTEvent1List.add(new ECT_EVENT_1("Tech Hunt","http://anurag.edu.in/wp-content/uploads/2012/quiz.jpg"));
        ECTEvent1List.add(new ECT_EVENT_1("Mat-Mania","https://res.cloudinary.com/teepublic/image/private/s--91AeMXfq--/t_Preview/b_rgb:262c3a,c_limit,f_auto,h_313,q_90,w_313/v1496756374/production/designs/1649485_1"));
        ECTEvent1List.add(new ECT_EVENT_1("AquaBoat","https://bookboon.com/thumbnail/720/47f230d1-2d56-4cb9-9d04-a0f600b34b87/495eed07-fa5c-40b4-9667-a5d400e1a9ca/c-1-introduction-to-programming-and-the-c-language.jpg"));

    }

    void Circlemenu(View v)
    {
        Intent in = new Intent(getApplicationContext(),Floatingmenu.class);
        startActivity(in);
    }


}
