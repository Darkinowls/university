package lab6.models;

import lab6.interfaces.Consts;
import lab6.annotations.ClassAnnot;
import lab6.annotations.MyAnnotation;

@ClassAnnot(name = "lab6.model.MyTime")

// Так виглядає патерн Singleton
public final class MyTime extends Watch implements  Consts {
    private int hour = 0;
    private int minute = 0;
    private static MyTime myTime;

    private MyTime(int hour, int minute) throws Exception {
        this.setHour(hour);
        this.setMinute(minute);
    }

    //отримаємо єдиний екзепляр або створюємо його
    public static MyTime getInstance(int hour, int minute) throws Exception {
        if (myTime == null) myTime = new MyTime(hour, minute);
        return myTime;
    }

    @MyAnnotation(name = "setHour")
    public void setHour(int hour) throws Exception {
        // примітивна перевірка вхідних даних
        if (hour < MINHOUR || hour > MAXHOUR) throw new Exception("Hour has to be within 0 and 23 ");
        this.hour = hour;
    }

    public  void setMinute(int minute) throws Exception {
        // примітивна перевірка вхідних даних
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
