package org.example.model;

import org.example.model.familyTree.FamilyTree;
import org.example.model.person.Person;
import org.example.model.save.FileProcessing;

import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private FileProcessing writable;
    private final String fileAddress = "FamilyTree.txt";
    private FamilyTree<Person> activeTree;

    public Service(FamilyTree<Person> activeTree) {
        this.activeTree = activeTree;
    }

    public Service(){
        activeTree = new FamilyTree<>();
    }

    public void save() throws IOException {
        writable.save(activeTree, fileAddress);
    }

    public FamilyTree<Person> read() throws IOException, ClassNotFoundException {
        return activeTree = (FamilyTree<Person>) writable.read(fileAddress);
    }

    public void addPerson(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate){
        activeTree.addPerson(new Person(firstName, lastName, birthDate, deathDate));
    }
    public void sortByName(){
        activeTree.sortByName();
    }

    public void sortByBirthday(){
        activeTree.sortByBirthday();
    }

    public String getInfo() {
        return activeTree.toString();
    }

}
