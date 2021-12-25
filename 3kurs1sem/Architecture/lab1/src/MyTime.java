@Deprecated
@ClassAnnot(name = "MyTime")
public final class MyTime extends MyData implements IWatch, Consts {
    private int hour = -1;
    private int minute = -1;

    public MyTime(int year, int month, int day, int hour, int minute) {
        super(year, month, day);
        this.setHour(hour);
        this.setMinute(minute);
    }

    private MyTime(int hour, int minute) {
        this.setHour(hour);
        this.setMinute(minute);
    }

    public MyTime() {
    }

    @MyAnnotation(name = "setHour")
    public void setHour(int hour) {
        if (hour < MINHOUR || hour > MAXHOUR) try {
            throw new Exception("Hour has to be within 0 and 23 ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hour = hour;
    }

    public void setMinute(int minute) {
        if (minute < MINMINUTE || minute > MAXMINUTE) try {
            throw new Exception("Minute has to be within 0 and 59 ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.minute = minute;
    }

    @MyAnnotation(name = "getHour", returns = "hour in int")
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public void showAll() {
        super.showAll();
        System.out.println("\tTime show");
        System.out.print(((this.hour == -1) ? "Set valid hour" : "hour:" + this.getHour()) + " ");
        System.out.print(((this.minute == -1) ? "Set valid minute" : "minute:" + this.getMinute()) + "\n");
    }

    @MyAnnotation(name = "toString", returns = "string with time + data")
    public String toString() {
        return this.getHour() + ":" + this.getMinute() + " " + this.getDay() + "." + this.getMonth() + "." + this.getYear();
    }

}
