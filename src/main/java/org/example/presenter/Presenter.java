package org.example.presenter;

import org.example.model.Service;
import org.example.view.View;

import java.time.LocalDate;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addPerson(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate) {
        service.addPerson(firstName, lastName, birthDate, deathDate);
    }

    public void getPersonList() {
        String answer = service.getInfo();
        view.print(answer);
    }

    public void sortByName(){
        service.sortByName();
    }

    public void sortByBirthday(){
        service.sortByBirthday();
    }
}
