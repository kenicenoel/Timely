package kenice.com.timely;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class FragmentContainer extends AppCompatActivity
{
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);
        setTitle("Timely");

        MainFragment fragment = new  MainFragment();
        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().add(R.id.framentHolder, fragment, "Main").commit();


    }
}
