package ca.ualberta.marcinko.marcinko_fueltrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/*Activity for Adding Log entries, called by clicking add log button on main page
*/

public class AddLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_log);

        //getting log entry info on click
        EditText getDate = (EditText)findViewById(R.id.entered_date);
        EditText getStation = (EditText)findViewById(R.id.entered_station);
        EditText getOdometerRead = (EditText)findViewById(R.id.entered_odometer_read);
        EditText getFuelGrade = (EditText)findViewById(R.id.entered_fuel_grade);
        EditText getFuelAmount = (EditText)findViewById(R.id.entered_fuel_amount);
        EditText getFuelUnitCost = (EditText)findViewById(R.id.entered_fuel_unit_cost);

        //String date, String station, double odometer, String grade, double amount, double unitCost
        //converting to usable
        String userDate = getDate.getText().toString();
        String userStation = getStation.getText().toString();
        Double userOdometer = Double.parseDouble(getOdometerRead.getText().toString());
        String userGrade = getFuelGrade.getText().toString();
        Double userFuelAmount = Double.parseDouble(getFuelAmount.getText().toString());
        Double userUnitCost = Double.parseDouble(getFuelUnitCost.getText().toString());

        //placing all log info into log entry object
        LogEntry logEntry = new LogEntry(userDate, userStation, userOdometer, userGrade, userFuelAmount, userUnitCost);

        Button saveLogButton = (Button)findViewById(R.id.save_log_button);
        saveLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save log click
                // TODO: save log entry into LogActivity,  LogList and save to file
                Intent getViewLogsIntent = new Intent(AddLogActivity.this, LogActivity.class);
                startActivity(getViewLogsIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_log, menu);
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
