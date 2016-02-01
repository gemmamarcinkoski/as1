package ca.ualberta.marcinko.marcinko_fueltrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity {

    private static LogList logList;
    public static final String FILENAME = "file.sav";

    private static ArrayAdapter<LogEntry> adapter;

    public static ArrayAdapter<LogEntry> getAdapter() {
        return adapter;
    }

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

        loadFromFile();

        adapter = new ArrayAdapter<LogEntry>(this, R.layout.list_item, logList.getEntries());


    }
    public static LogList getLogList() {
        return logList;
    }


    //From Lab 2 in class Gson lonely twitter example
    private void loadFromFile() {
        try{
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            // Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 01-1
            Type listType = new TypeToken<List<LogEntry>>(){}.getType();
            logList = new LogList((List<LogEntry>)(gson.fromJson(in, listType)));

        } catch (FileNotFoundException e) {
            //no file yet, create new log list
            logList = new LogList();
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

}

