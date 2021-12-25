package project.commands;

import project.interfaces.Command;
import project.interfaces.Controller;

// патерн Command
// прінтер для виведення даних командами через конкретний контроллер, що містить модель (Model) та вид(View)
public class Printer {
    private final Command helloCommand;
    private final Command outDateCommand;
    private final Command outTimeCommand;
    private final Command outAllCommand;

    // Заповнюємо принтер командами і конкретизуємо їх через дані контролера
    public Printer(Controller controller) {
        this.helloCommand = new HelloCommand();
        this.outDateCommand = new OutDateCommand(controller);
        this.outTimeCommand = new OutTimeCommand(controller);
        this.outAllCommand = new OutAllCommand(controller);
    }

    public void Hello() {
        helloCommand.execute();
    }

    public void outDate() {
        outDateCommand.execute();
    }

    public void outTime() {
        outTimeCommand.execute();
    }

    public void outAll() {
        outAllCommand.execute();
    }
}
