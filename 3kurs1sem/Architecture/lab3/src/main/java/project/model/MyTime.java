package project.model;

import project.interfaces.Consts;
import project.interfaces.IWatch;
import project.annotation.ClassAnnot;
import project.annotation.MyAnnotation;

@ClassAnnot(name = "project.model.MyTime")
public class MyTime extends MyData implements IWatch, Consts {
    private int hour = 0;
    private int minute = 0;

    public MyTime(int year, int month, int day, int hour, int minute) throws Exception {
        super(year, month, day);
        this.setHour(hour);
        this.setMinute(minute);
    }


    public MyTime() throws Exception {
        super();
    }

    @MyAnnotation(name = "setHour")
    public void setHour(int hour) throws Exception {
        if (hour < MINHOUR || hour > MAXHOUR) throw new Exception("Hour has to be within 0 and 23 ");

        this.hour = hour;
    }

    public void setMinute(int minute) throws Exception {
        if (minute < MINMINUTE || minute > MAXMINUTE) throw new Exception("Minute has to be within 0 and 59 ");

        this.minute = minute;
    }

    @MyAnnotation(name = "getHour", returns = "hour in int")
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }


}
