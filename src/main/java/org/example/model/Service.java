package org.example.model;

import org.example.model.familyTree.FamilyTree;
import org.example.model.person.Person;
import org.example.model.save.FileHandler;

import java.time.LocalDate;

public class Service {
    private FileHandler handler;
    private FamilyTree<Person> activeTree;

    public Service(FamilyTree<Person> activeTree) {
        this.handler = new FileHandler();
        this.activeTree = activeTree;
    }
    public FamilyTree<Person> getActiveTree() {
        return activeTree;
}
    public FileHandler getHandler() {
        return handler;
    }
    public void setTree(FamilyTree<Person> activeTree) {
        this.activeTree = activeTree;
    }
    public void setHandler(FileHandler handler) {
        this.handler = handler;
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
