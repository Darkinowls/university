package project.commands;

import project.interfaces.Command;
import project.interfaces.Controller;
import project.models.MyDate;
import project.models.Watch;

// для патерну Command
public class OutDateCommand implements Command {
    private Controller controller;

    public OutDateCommand(Controller controller) {
        this.controller = controller;
    }

    public void execute() {
        //для нумерації (красиво)
        int i = 1;
        Watch t = controller.getModel();
        // перебираємо моделі класу MyDate, оскільки ми використовуємо патерн Chain of Responsibility
        while (t != null) {
            if (t instanceof MyDate) {
                // Виводимо дані за заданим видом (View)
                System.out.print(i++ + ". " );
                controller.getView().printData(t);
            }
            t = t.next;
        }
    }
}
