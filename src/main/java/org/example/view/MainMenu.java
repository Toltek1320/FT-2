package org.example.view;

import org.example.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Option> list;
    public ConsoleUI consoleUI;
    public MainMenu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        list = new ArrayList<>();
        list.add(new AddPerson(consoleUI));
        list.add(new GetPersonList(consoleUI));
        list.add(new SortByName(consoleUI));
        list.add(new SortByBirthday(consoleUI));
        list.add(new Finish(consoleUI));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int num){
        Option option = list.get(num-1);
        option.execute();
    }
    public int getSize(){
        return list.size();
    }
}