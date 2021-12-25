package project.interfaces;

public interface IWatch {

    void setHour(int hour) throws Exception;
    void setMinute(int minute) throws Exception;
    void setYear(int year) throws Exception;
    void setMonth(int month) throws Exception;
    void setDay(int day) throws Exception;


    int addDays(int d1,int d2);
    int getHour();
    int getMinute();
    int getYear();
    String getMonth();
    int getDay();



}
