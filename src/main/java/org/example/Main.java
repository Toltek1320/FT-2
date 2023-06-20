package org.example;

import org.example.model.Service;
import org.example.model.familyTree.FamilyTree;
import org.example.model.person.Gender;
import org.example.model.person.Person;
import org.example.presenter.Presenter;
import org.example.view.ConsoleUI;
import org.example.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree<Person> tree = new FamilyTree<>();
        tree.addPerson(new Person("Иван", "Петров", Gender.Male,
                LocalDate.of(1911, 2, 15),  LocalDate.of(1975, 2, 26)));
        tree.addPerson(new Person("Ольга", "Петрова", Gender.Female,
                LocalDate.of(1915,1, 14),LocalDate.of(1986,3, 8)));
        tree.addPerson(new Person("Дарья", "Петрова", Gender.Female,
                LocalDate.of(1951, 4, 16), LocalDate.of(2013, 9, 12),
                tree.getByName("Ольга", "Петрова"), tree.getByName("Иван", "Петров")));
        tree.addPerson(new Person("Петр", "Петров", Gender.Male,
                LocalDate.of(1945, 6, 29), LocalDate.of(1999, 8, 13),
                tree.getByName("Ольга", "Петрова"), tree.getByName("Иван", "Петров")));

        Service service = new Service(tree);
        View view = new ConsoleUI();
        new Presenter(view, service);
        view.start();
    }
}