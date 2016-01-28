package ca.ualberta.marcinko.marcinko_fueltrack;

/**
 * Created by marcinko on 1/28/16.
 */
public class LogEntry {
    private String date;
    private String station;
    private double odometer;
    private String grade;
    private double amount;
    private double unitCost;
    private double cost;

    public LogEntry(String date, String station, double odometer, String grade, double amount, double unitCost) {
        this.date = date;
        this.station = station;
        this.odometer = odometer;
        this.grade = grade;
        this.amount = amount;
        this.unitCost = unitCost;
        fuelUpdate();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
        fuelUpdate();
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
        fuelUpdate();
    }

    public double getCost() {
        return cost;
    }

    private void fuelUpdate(){
        cost = unitCost*amount/100;
    }
}
