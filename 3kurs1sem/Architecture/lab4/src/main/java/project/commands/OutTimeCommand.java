package project.commands;

import project.interfaces.Command;
import project.interfaces.Controller;
import project.models.MyDate;
import project.models.MyTime;
import project.models.Watch;

// для патерну Command
public class OutTimeCommand implements Command {

    private Controller controller;

    public OutTimeCommand(Controller controller) {
        this.controller = controller;
    }

    public void execute() {
        //для нумерації (красиво)
        int i = 1;
        Watch t = controller.getModel();
        // перебираємо моделі класу MyTime, оскільки ми використовуємо патерн Chain of Responsibility
        while (t != null) {
            if (t instanceof MyTime) {
                // Виводимо дані за заданим видом (View)
                System.out.print(i++ + ". " );
                controller.getView().printTime(t);
            }
            t = t.next;
        }
    }
}
