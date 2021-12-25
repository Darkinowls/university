public interface IWatch {
    String toString();
    void showAll();

    void setHour(int hour);
    void setMinute(int minute);
    void setYear(int year);
    void setMonth(int month);
    void setDay(int day);

    int getHour();
    int getMinute();
    int getYear();
    int getMonth();
    int getDay();



}
