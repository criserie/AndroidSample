package androidsample.example.com.androidsample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.TextView;

public class AndroidSampleActivity extends AppCompatActivity {
    int messagenum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_sample);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final TextView myView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button_id);
        final SmsManager smsManager = SmsManager.getDefault();


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!myView.getText().equals("changed"))
                    myView.setText("changed");
                else
                    myView.setText("Changed Back!!!");

                while(messagenum <= 7)
                {
                    int breakTimer = 0;
                    try {
                        smsManager.sendTextMessage("520-881-0062", null, "I just built an app that will send you this message 7 times, this is Text " + messagenum + " of 7.", null, null);
                    } catch (IllegalArgumentException ie) {
                        myView.setText("IllegalArgumentException Thrown");
                    }

                    while (breakTimer < 1000000000)
                    {
                        breakTimer++;
                    }
                    messagenum++;
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_android_sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
