package ca.ualberta.marcinko.marcinko_fueltrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;

/*this class gets transitions from the main page view/edit log button and from a log entry save button
*/
public class LogActivity extends AppCompatActivity {
    private ListView oldEntriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        Button goHomeButton = (Button)findViewById(R.id.home_button);

        goHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //going to the home screen
                Intent goHomeIntent = new Intent(LogActivity.this, MainActivity.class);
                startActivity(goHomeIntent);
            }
        });

        TextView calculation = (TextView)findViewById(R.id.textView);
        //concatenating calculated total to current textView
        String totalCost = getString(R.string.total_cost_header) + MainActivity.getLogList().calculateTotalCost();
        calculation.setText(totalCost);

        oldEntriesList = (ListView) findViewById(R.id.listView);
        oldEntriesList.setAdapter(MainActivity.getAdapter());

    }




}
