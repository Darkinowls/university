package Lab5;

import java.util.Date;

public class MyTime extends MyDate {
    private int hours;
    private int minutes;


    public MyTime(int day, int month, int year, int hours, int minutes) throws Exception {
        super(day, month, year);
        setHours(hours);
        setMinutes(minutes);
    }

    public MyTime(int hours, int minutes) throws Exception {
        setHours(hours);
        setMinutes(minutes);
    }

    @SuppressWarnings("deprecation")
    public MyTime() {
        super();
        Date d = new Date();
        this.hours = d.getHours();
        this.minutes = d.getMinutes();
    }


    @MyAnnotation(name = "getHours")
    public int getHours() {
        return hours;
    }

    private void setHours(int hours) throws Exception {
        if (hours > 24 || hours < 0 ){
            throw new Exception("INCORRECT HOUR!");
        }
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    private void setMinutes(int minutes) throws Exception {
        if (minutes > 60 || minutes < 0 ){
            throw new Exception("INCORRECT MINUTES!");
        }
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return "MyTime{" +
                "hours=" + getHours() +
                ", minutes=" + getMinutes() +
                ", " +super.toString() +
                "} ";
    }
}
