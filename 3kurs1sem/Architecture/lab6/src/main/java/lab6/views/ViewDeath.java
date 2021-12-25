package lab6.views;


import lab6.interfaces.View;
import lab6.models.MyDate;
import lab6.models.MyTime;
import lab6.models.Watch;

public class ViewDeath implements View {

    public void printData(Watch data) {

        System.out.print("The data of death is " + ((MyDate) data).getDay() + "." + ((MyDate) data).getMonth() + "." +
                ((MyDate) data).getYear() + "\n");

    }


    public void printTime(Watch time) {
        System.out.print("The time of death is " + ((MyTime) time).getHour() +
                ":" + ((MyTime) time).getMinute() + "\n");
    }
}





