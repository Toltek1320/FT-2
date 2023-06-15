package org.example.view.commands;

import org.example.view.ConsoleUI;

public class SortByName extends Command{

    public SortByName(ConsoleUI consoleUI) {

        super(consoleUI);
    }

    @Override
    public String description() {
        return "Отсортировать по имени";
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}
