package Lab5;

import java.util.Calendar;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) throws Exception {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public MyDate() {
        Calendar calendar = Calendar.getInstance();
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.month = calendar.get(Calendar.MONTH);
        this.year = calendar.get(Calendar.YEAR);
    }


    public int getDay() {
        return day;
    }

    private void setDay(int day) throws Exception {
        if (day > 31 || day <= 0) {
            throw new Exception("INCORRECT DAY!");
        }
        this.day = day;
    }

    public int getMonth() {
        return (month + 1);
    }

    private void setMonth(int month) throws Exception {
        if (month > 12 || month <= 0) {
            throw new Exception("INCORRECT MONTH!");
        }
        this.month = month - 1;
    }

    public int getYear() {
        return year;
    }

    @MyAnnotation(name = "setYear")
    private void setYear(int year) throws Exception {
        if (year < 0) {
            throw new Exception("INCORRECT YEAR!");
        }
        this.year = year;
    }


    @Override
    public String toString() {
        return "MyDate{" +
                "day=" + getDay() +
                ", month=" + getMonth() +
                ", year=" + getYear() +
                '}';
    }
}
