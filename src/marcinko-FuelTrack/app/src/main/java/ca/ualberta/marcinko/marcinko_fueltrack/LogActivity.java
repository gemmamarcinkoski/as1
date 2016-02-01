package ca.ualberta.marcinko.marcinko_fueltrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;

/*this class gets transitions from the main page view/edit log button and from a log entry save button
*/
public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        TextView calculation = (TextView)findViewById(R.id.textView);
        //concatenating calculated total to current textView
        String totalCost = getString(R.string.total_cost_header) + MainActivity.getLogList().calculateTotalCost();
        calculation.setText(totalCost);

    }




}
