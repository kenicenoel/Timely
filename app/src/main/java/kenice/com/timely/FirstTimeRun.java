package kenice.com.timely;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import kenice.com.timely.Extras.SettingsBuddy;


public class FirstTimeRun extends AppCompatActivity
{
    private EditText user;
    private Button saveNameButton;
    private SettingsBuddy buddy;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firsttimerun);
        buddy = new SettingsBuddy(this);

        user = (EditText) findViewById(R.id.nameOfUser);
        saveNameButton = (Button) findViewById(R.id.saveName);
        saveNameButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String fullName = user.getText().toString();
                if (fullName.length() < 2)
                {
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Sorry. You need to enter a valid name or nickname of at least 2 characters.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }

                else
                {
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Thank you, "+user.getText().toString()+", Let's get started.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    buddy.setFullName(fullName);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        });


    }
}