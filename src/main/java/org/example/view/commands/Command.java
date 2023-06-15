package org.example.view.commands;

import org.example.model.Service;
import org.example.view.ConsoleUI;

public abstract class Command implements Option {
    private final ConsoleUI consoleUI;
    private Service service;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }
}

