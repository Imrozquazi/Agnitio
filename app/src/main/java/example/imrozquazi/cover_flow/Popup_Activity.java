package example.imrozquazi.cover_flow;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Popup_Activity extends AppCompatActivity {

        Dialog mydialog;
    TextView txtclose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_);


        mydialog = new Dialog(this);
        txtclose = (TextView)findViewById(R.id.canceltxt);



    }

    void back(View v)
    {
        mydialog.dismiss();
    }
}
