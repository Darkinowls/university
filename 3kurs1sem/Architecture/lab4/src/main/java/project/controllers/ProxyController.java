package project.controllers;

import project.interfaces.Controller;
import project.interfaces.View;
import project.models.Watch;
import project.views.ViewBirth;

// проксі клас для класу MyController. Має ті самі функції, що і MyController, проте деякі функції доповнені
public class ProxyController implements Controller {
    // використовуємо композицію, а не унаслідування
    public MyController controller;

    public ProxyController(Watch watch){
        controller = new MyController(new ViewBirth(), watch);
    }

    @Override // наш проксі контролер ставить обмеження на встановлення View.
    public void setView(View view) {
        System.out.println("The only available view is ViewBirth!");
    }

    @Override
    public void setModel(Watch model) {
        //Повідомляє про спрацювання своїх методів.
        System.out.println("Setting a new model in proxy controller ...");
        // викликаємо старий метод
        controller.setModel(model);
    }

    @Override

    public Watch getModel() {
        // Повідомляє про спрацювання своїх методів.
        System.out.println("Getting a Model from proxy controller ...");
        // викликаємо старий метод
        return controller.getModel();
    }

    @Override

    public View getView() {
        // Повідомляє про спрацювання своїх методів.
        System.out.println("Getting a View from proxy controller ...");
        // викликаємо старий метод
        return controller.getView();
    }



}
