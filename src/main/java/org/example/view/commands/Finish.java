package org.example.view.commands;

import org.example.view.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super (consoleUI);
    }
    @Override
    public String description() {
        return "Закончить работу";
    }
    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
