package org.example.view.commands;

import org.example.view.ConsoleUI;

public class GetPersonList extends Command {
    private ConsoleUI consoleUI;

    public GetPersonList(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    public String description(){
        return "Получить список людей";
    }

    public void execute(){
        getConsoleUI().getPersonList();
    }
}
