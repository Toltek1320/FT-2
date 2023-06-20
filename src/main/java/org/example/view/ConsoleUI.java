package org.example.view;

import org.example.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private final Scanner scan;
    private final MainMenu mainMenu;
    private boolean work;

    public ConsoleUI() {
        work = true;
        scan = new Scanner(System.in);
        mainMenu = new MainMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        while (work){
            System.out.println(mainMenu.print());
            String choice = scan.nextLine();
            if (check(choice)){
                mainMenu.execute(Integer.parseInt(choice));
            }else {
                fail();
            }
        }
    }

    private boolean check(String text){
        return  text.matches("[0-9]+") && Integer.parseInt(text) <= mainMenu.getSize()
                && Integer.parseInt(text) > 0;
    }

    public void fail() {
        System.out.println("Неверный ввод!");
    }

    public void getPersonList(){
        presenter.getPersonList();
    }

    public void addPerson(){
        System.out.println("Введите имя: ");
        String firstName = scan.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scan.nextLine();
        System.out.println("Введите дату рождения (пример: 2023-01-20): ");
        String birthDate_str = scan.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDate_str);
        System.out.println("Введите дату смерти (пример: 2011-02-11): ");
        String deathDate_str = scan.nextLine();
        LocalDate deathDate = LocalDate.parse(deathDate_str);
        presenter.addPerson(firstName,lastName, birthDate, deathDate);
    }

    public void sortByName(){
        presenter.sortByName();
    }
    public void sortByBirthday(){
        presenter.sortByBirthday();
    }

    public void finish(){
        work = false;
    }

}
