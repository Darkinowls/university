package lab6.commands;

import lab6.interfaces.Command;

// для патерну Command
public class HelloCommand implements Command {

    public void execute() {
        System.out.println("Hello, The ultimate constructor 2022 works!");
    }
}
