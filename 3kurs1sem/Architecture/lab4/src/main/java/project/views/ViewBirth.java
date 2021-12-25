package project.views;


import project.interfaces.View;
import project.models.MyDate;
import project.models.MyTime;
import project.models.Watch;

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

