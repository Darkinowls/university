package project;

public interface IWatch {
    String toString();
    void showAll();

    void setHour(int hour) throws Exception;
    void setMinute(int minute) throws Exception;
    void setYear(int year) throws Exception;
    void setMonth(int month) throws Exception;
    void setDay(int day) throws Exception;

    int getHour();
    int getMinute();
    int getYear();
    String getMonth();
    int getDay();



}
