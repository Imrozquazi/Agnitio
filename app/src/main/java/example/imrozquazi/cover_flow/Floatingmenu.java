package example.imrozquazi.cover_flow;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class Floatingmenu extends AppCompatActivity {

    String arrayName[] = { "Facebook",
            "Instagram",
            "Twitter",
            "Windows",
            "Website"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floatingmenu);

        CircleMenu circlemenu = (CircleMenu)findViewById(R.id.Circlemenu);
        circlemenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.ic_group_add_black_24dp,R.drawable.ic_group_add_black_24dp);
        circlemenu.addSubMenu(Color.parseColor("#CDCDCD"),R.drawable.ic_launcher_background);
        circlemenu.addSubMenu(Color.parseColor("#258CFF"),R.drawable.ic_launcher_background);
        circlemenu.addSubMenu(Color.parseColor("#CDCDCD"),R.drawable.ic_launcher_background);
        circlemenu.addSubMenu(Color.parseColor("#258CFF"),R.drawable.ic_launcher_background);
        circlemenu.addSubMenu(Color.parseColor("#000000"),R.drawable.ic_launcher_background);


    }
    }

