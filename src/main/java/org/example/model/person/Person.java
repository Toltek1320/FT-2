package org.example.model.person;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Serializable {
    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final LocalDate birthDate;
    private final LocalDate deathDate;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Person mother,
                 Person father) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(firstName, lastName, gender, birthDate, deathDate, null, null);
    }

    public Person(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate) {
        this(firstName, lastName, null, birthDate, deathDate, null, null);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public String getAge() {
        return "продолжительность жизни: " + Period.between(birthDate, deathDate).getYears() + " years";
    }

    public void addChild(Person person) {
        if (!children.contains(person)) {
            children.add(person);
        }
    }

    public String getMotherInfo() {
        String str = "мать: ";
        if (mother != null) {
            str += mother.getFirstName() + " " + mother.getLastName();
        } else {
            str += "unknown";
        }
        return str;
    }

    public String getFatherInfo() {
        String str = "отец: ";
        if (father != null) {
            str += father.getFirstName() + " " + father.getLastName();
        } else {
            str += "unknown";
        }
        return str;
    }

    public String getChildrenInfo() {
        StringBuilder str = new StringBuilder("дети: ");
        if (children.size() != 0) {
            for (Person child : children) {
                str.append(child.getFirstName()).append(" ").append(child.getLastName()).append(", ");
            }
        } else {
            str.append("unknown");
        }
        return str.toString().replaceAll(", $", "");
    }

    @Override
    public String toString() {
        return "Имя: " + firstName + " " + lastName + ", пол: " + gender + ", дата рождения: " + birthDate +
                ", дата смерти: " + deathDate + ", " + getAge() + ", " + getMotherInfo() + ", " + getFatherInfo() +
                ", " + getChildrenInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) &&
                gender == person.gender && Objects.equals(birthDate, person.birthDate) &&
                Objects.equals(deathDate, person.deathDate) && Objects.equals(mother, person.mother) &&
                Objects.equals(father, person.father) && Objects.equals(children, person.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender);
    }
}
