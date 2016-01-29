package ca.ualberta.marcinko.marcinko_fueltrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addLogButton = (Button)findViewById(R.id.addLogButton);
        Button viewEditLogsButton = (Button)findViewById(R.id.viewEditLogsButton);

        addLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //going to the add log activity class
                Intent getAddLogIntent = new Intent(MainActivity.this, AddLogActivity.class);
                startActivity(getAddLogIntent);
            }
        });

        viewEditLogsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //going to logs list view
                Intent getLogsIntent = new Intent(MainActivity.this, LogActivity.class);
                startActivity(getLogsIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

