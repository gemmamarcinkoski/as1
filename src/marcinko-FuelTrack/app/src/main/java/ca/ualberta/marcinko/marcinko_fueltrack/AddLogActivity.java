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

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


/*Activity for Adding Log entries, called by clicking add log button on main page
*/

public class AddLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_log);

        //getting log entry info
        final EditText getDate = (EditText)findViewById(R.id.entered_date);
        final EditText getStation = (EditText)findViewById(R.id.entered_station);
        final EditText getOdometerRead = (EditText)findViewById(R.id.entered_odometer_read);
        final EditText getFuelGrade = (EditText)findViewById(R.id.entered_fuel_grade);
        final EditText getFuelAmount = (EditText)findViewById(R.id.entered_fuel_amount);
        final EditText getFuelUnitCost = (EditText)findViewById(R.id.entered_fuel_unit_cost);



        Button saveLogButton = (Button)findViewById(R.id.save_log_button);
        saveLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

                //updating logList
                MainActivity.getLogList().addEntry(logEntry);

                //save log click
                saveInFile();
                Intent getViewLogsIntent = new Intent(AddLogActivity.this, LogActivity.class);
                startActivity(getViewLogsIntent);

            }
        });
    }

    private void saveInFile(){
        try{
            FileOutputStream fos = openFileOutput(MainActivity.FILENAME,0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(MainActivity.getLogList().getEntries(), out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }
}
