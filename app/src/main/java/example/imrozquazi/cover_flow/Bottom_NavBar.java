package example.imrozquazi.cover_flow;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//comment by ashay

public class Bottom_NavBar extends AppCompatActivity {

    private TextView mTextMessage;
    private FirebaseAuth mAuth;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);
                    fragment_home frag1 = new fragment_home();
                    FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                    ft1.replace(R.id.fram,frag1);
                    ft1.commit();
                    return true;

                case R.id.navigation_dashboard:
                   // mTextMessage.setText(R.string.title_dashboard);
                    fragment_home frag2 = new fragment_home();
                    FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                    ft2.replace(R.id.fram,frag2);
                    ft2.commit();
                    return true;

                case R.id.navigation_notifications:
                   // mTextMessage.setText("Profile");
                    Profile frag3 = new Profile();
                    FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                    ft3.replace(R.id.fram,frag3);
                    ft3.commit();
                    return true;

                case R.id.navigation_Logout:
                   // mTextMessage.setText("Logout");
                    /*
                    fragment_home frag4 = new fragment_home();
                    FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                    ft4.replace(R.id.fram,frag4);
                    ft4.commit();*/

                    mAuth.signOut();
                    startActivity(new Intent(getApplicationContext(),Login.class));
                    return true;
            }
            return false;


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom__nav_bar);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragment_home fragment = new fragment_home();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fram,fragment);
        ft.commit();

        mAuth=FirebaseAuth.getInstance();

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user =FirebaseAuth.getInstance().getCurrentUser();
        if(user == null)
        {
            startActivity(new Intent(getApplicationContext(),Login.class));
        }
    }
}
