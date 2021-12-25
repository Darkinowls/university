package project;

import project.Consts;
import project.Month;
import project.MyAnnotation;

public class MyData implements Consts {
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


    public void showAll() {
        System.out.println("\tData show");
        System.out.print(((this.day == 0) ? "Set valid day" : "day:" + this.getDay()) + " ");
        System.out.print(((this.month.ordinal() == 0) ? "Set valid month" : "month:" + this.getMonth()) + " ");
        System.out.print((this.year == -1) ? "Set valid year" : "year:" + this.getYear() + "\n");

    }

    @MyAnnotation(name = "toString", returns = "data")
    public String toString() {
        return this.getDay() + "." + this.getMonth() + "." + this.getYear();
    }


}
