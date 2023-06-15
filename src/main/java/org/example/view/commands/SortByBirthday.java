package org.example.view.commands;

import org.example.view.ConsoleUI;

public class SortByBirthday extends Command{
    public SortByBirthday(ConsoleUI consoleUI) {

        super(consoleUI);
    }

    @Override
    public String description() {
        return "Отсортировать по дате рождения";
    }

    @Override
    public void execute() {
        getConsoleUI().sortByBirthday();
    }
}
