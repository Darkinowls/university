package lab6.commands;

import lab6.interfaces.Command;
import lab6.interfaces.Controller;
import lab6.models.MyDate;
import lab6.models.MyTime;
import lab6.models.Watch;

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
        while (t != null /*&& t != t.next*/) {
            if (t instanceof MyTime) {
                // Виводимо дані за заданим видом (View)
                System.out.print(i++ + ". " );
                controller.getView().printTime(t);
            }
            t = t.next;
        }
    }
}
