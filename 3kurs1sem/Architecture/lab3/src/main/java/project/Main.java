package project;

import project.controller.Controller;
import project.interfaces.IWatch;
import project.model.MyData;
import project.model.MyTime;
import project.view.ViewBirth;
import project.view.ViewDeath;

import java.util.Scanner;

public class Main {

    public static MyTime input() throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter year");
        int year = scan.nextInt();

        System.out.println("Enter month");
        int month = scan.nextInt();

        System.out.println("Enter day");
        int day = scan.nextInt();

        System.out.println("Enter hour");
        int hour = scan.nextInt();

        System.out.println("Enter minute");
        int minute = scan.nextInt();

        return new MyTime(year, month, day, hour, minute);
    }

    public static void main(String[] args) throws Exception {

        MyTime myTime;

//        myTime = input();
        myTime = new MyTime(2000, 4, 3, 12, 48);

        Controller.setModel(myTime);
        Controller.setView(new ViewBirth());


        Controller.outData();
        Controller.outTime();

        System.out.print("\n");

        Controller.setView(new ViewDeath());

        Controller.outAll();

        IWatch myData = new MyData(2090, 6, 30);

        Controller.setView(new ViewBirth());
        Controller.setModel((IWatch) myData);

        Controller.outData();

    }
}
