package project.controller;

import project.interfaces.IWatch;
import project.interfaces.View;
import project.model.MyData;
import project.model.MyTime;
import project.view.ViewBirth;

public class Controller {
    private static View view;
    private static IWatch model;

    public Controller(View view, IWatch model) {
        Controller.view = view;
        Controller.model = model;
    }

    public static void setView(View view) {
        Controller.view = view;
    }

    public static void setModel(IWatch model) {
        Controller.model = model;
    }

    public static IWatch getModel() {
        return Controller.model;
    }

    public static void outData() {
        view.printData(model);
    }

    public static void outTime() {
        view.printTime(model);
    }

    public static void outAll() {
        view.printAll(model);
    }

    public static void hello(){
        System.out.println("Hello, the controller works");
    }


}
