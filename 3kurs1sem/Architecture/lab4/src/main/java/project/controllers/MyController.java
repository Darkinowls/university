package project.controllers;

import project.interfaces.Controller;
import project.interfaces.View;
import project.models.Watch;

// Використовуємо сінглтон для створення єдиного контролера
public class MyController implements Controller {
    private View view;
    private Watch model;

    public MyController(View view, Watch model) {
        this.view = view;
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setModel(Watch model) {
        this.model = model;
    }

    public Watch getModel() {
        return this.model;
    }

    public View getView() {
        return this.view;
    }



}
