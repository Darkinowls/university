package project.model;

import project.interfaces.Consts;
import project.Month;
import project.annotation.MyAnnotation;
import project.interfaces.IWatch;


public class MyData implements Consts, IWatch {
    private int year;
    private Month month;
    private int day;

    public MyData(int year, int month, int day) throws Exception {
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
    }

    public MyData() {
        this.year = 0;
        this.month = Month.January;
        this.day = 0;
    }

    @MyAnnotation(name = "getYear")
    public int getYear() {
        return year;
    }

    public String getMonth() {
        Month m = Month.valueOf(String.valueOf(month));
        return m.name();
    }

    public int getDay() {
        return day;
    }

    @Override
    public void setHour(int hour) throws Exception {
    }

    @Override
    public void setMinute(int minute) throws Exception {
    }

    public void setYear(int year) throws Exception {
        if (year < MINYEAR) throw new Exception("Year has not to be negative ");
        this.year = year;
    }

    public void setMonth(int month) throws Exception {
        if (month < MINMONTH || month > MAXMONTH) throw new Exception("project.Month has to be within 1 and 12");

        Month month1 = null;
        for (Month m :
                Month.values()) {
            if (m.ordinal() == month) month1 = m;
        }
        this.month = month1;

    }

    public void setDay(int day) throws Exception {
        if (day < MINDAY || day > MAXDAY) throw new Exception("Day has to be within 0 and 31");
        this.day = day;
    }

    public int getHour() {
        return 0;
    }

    @Override
    public int getMinute() {
        return 0;
    }

    public int addDays(int d1, int d2){
        return (d1 >= 0 && d2 >= 0)? ((d1 + d2) % 31) : 0;
    }
}
