package org.example.model.familyTree;

import org.example.model.familyTree.comparators.ComparatorByBirthday;
import org.example.model.familyTree.comparators.ComparatorByName;
import org.example.model.person.Person;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FamilyTreeInterface> implements Serializable, Iterable<E> {
    private final List<E> family;

    public FamilyTree(ArrayList<E> family) {
        this.family = family;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<E> getPersonList() {
        return family;
    }
    public void addPerson(E person){
        if(!family.contains(person)){
            family.add(person);
        }
        if (person.getFather() != null){
            person.getFather().addChild((Person) person);
        }
        if (person.getMother() != null){
            person.getMother().addChild((Person) person);
        }
    }

    public void removePerson(E person) {
        if (person.getMother() != null){
            person.getMother().getChildren().remove(person);
        }
        if (person.getFather() != null) {
            person.getFather().getChildren().remove(person);
        }
        family.remove(person);
    }

    public E getByName(String firstName, String lastName){
        for (E person: family) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)){
                return person;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E person: family){
            sb.append(person.toString()).append("\n");
        }
        return "В родословной: " + family.size() + " человека, а именно: " + "\n" + sb;
    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<>(family);
    }

    public void sortByName(){
        family.sort((Comparator<? super E>) new ComparatorByName());
    }

    public void sortByBirthday(){
        family.sort((Comparator<? super E>) new ComparatorByBirthday());
    }
}
