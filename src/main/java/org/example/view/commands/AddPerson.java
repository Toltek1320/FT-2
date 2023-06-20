package org.example.view.commands;

import org.example.view.ConsoleUI;

public class AddPerson extends Command {
    public AddPerson(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String description() {
        return "Добавить человека";
    }

    @Override
    public void execute() {
        getConsoleUI().addPerson();
    }
}
