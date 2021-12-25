package project.commands;

import project.interfaces.Command;
import project.interfaces.Controller;

// для патерну Command
public class OutAllCommand implements Command {

    private Controller controller;

    public OutAllCommand(Controller controller) {
        this.controller = controller;
    }

    public void execute() {

        OutDateCommand udc =  new OutDateCommand(controller);
        OutTimeCommand utc =  new OutTimeCommand(controller);
        //виконуємо усі команди - виводими усі дані
        udc.execute();
        utc.execute();
        System.out.println();

    }
}
