package org.example.model.familyTree.comparators;

import org.example.model.person.Person;

import java.util.Comparator;

public class ComparatorByName  implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}