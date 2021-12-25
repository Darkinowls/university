package project.view;


import project.interfaces.IWatch;
import project.interfaces.View;
import project.model.MyData;
import project.model.MyTime;

public class ViewDeath implements View {

    public void printData(IWatch data) {
        System.out.print( "Your data of death is " + data.getDay() + "." + data.getMonth() + "." + data.getYear() + "\n");
    }

    public void printTime(IWatch time) {
        System.out.print( "Your time of death is " + time.getHour()+ ":" + time.getMinute() + "\n");
    }

    public void printAll(IWatch time) {
        printData(time);
        printTime(time);
        System.out.print("\n");
    }

}

