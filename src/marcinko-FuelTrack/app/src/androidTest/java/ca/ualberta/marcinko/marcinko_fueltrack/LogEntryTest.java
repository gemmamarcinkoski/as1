package ca.ualberta.marcinko.marcinko_fueltrack;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by marcinko on 1/28/16.
 */
public class LogEntryTest extends ActivityInstrumentationTestCase2{
    public LogEntryTest() {
        super(LogEntryTest.class);
    }

    public void testFuelUpdate(){
        LogEntry myLogEntry = new LogEntry("2016", "esso",123.56,"premium",50,70.1);
        assertEquals(50*70.1/100,myLogEntry.getCost());
        myLogEntry.setAmount(60);
        assertEquals(60 * 70.1/100, myLogEntry.getCost());

        myLogEntry.setUnitCost(64.5);
        assertEquals(60*64.5/100,myLogEntry.getCost());

    }
}
