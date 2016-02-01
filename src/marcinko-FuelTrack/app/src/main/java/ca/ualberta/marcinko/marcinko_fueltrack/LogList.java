package ca.ualberta.marcinko.marcinko_fueltrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcinko on 1/28/16.
 * List object
 */
public class LogList {
    private List<LogEntry> entries;
    //add things, get things from index
    LogList(){
        this.entries = new ArrayList<>();
    }

    LogList (List<LogEntry> oldEntries ){
        this.entries = oldEntries;
    }

    public void addEntry(LogEntry entry){
        entries.add(entry);
    }

    public LogEntry getEntry(int index){
        return entries.get(index);
    }

    public List<LogEntry> getEntries() {
        return entries;
    }

    public double calculateTotalCost(){
        double totalCost = 0;
        for (int i=0; i<entries.size(); i++){
            totalCost = entries.get(i).getCost() + totalCost;
        }
        return totalCost;
    }
}
