package lab6.views;


import lab6.interfaces.View;
import lab6.models.MyDate;
import lab6.models.MyTime;
import lab6.models.Watch;

public class ViewBirth implements View {


    public void printData(Watch date) {
        System.out.print("The data of birth is " + ((MyDate) date).getDay() + "." + ((MyDate) date).getMonth() + "." +
                ((MyDate) date).getYear() + "\n");

    }


    public void printTime(Watch time) {
        System.out.print("The time of birth is " + ((MyTime) time).getHour() +
                ":" + ((MyTime) time).getMinute() + "\n");
    }

}

