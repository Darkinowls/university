package project.views;


import project.interfaces.View;
import project.models.MyDate;
import project.models.MyTime;
import project.models.Watch;

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





