package animals.GUI;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.sound.sampled.DataLine;

import animals.Zoo;
import animals.animalTypes.Camel;
import animals.animalTypes.Cat;
import animals.animalTypes.Dog;
import animals.animalTypes.Donkey;
import animals.animalTypes.Hamster;
import animals.animalTypes.Horse;


public class UI {
    private static int getOperation() throws IOException {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Добро пожаловать! Выберите пункт меню:");
        System.out.println("1: Завести новое животное");
        System.out.println("2: Показать список команд, которое выполняет животное");
        System.out.println("3: Обучить животное новым командам");
        System.out.println("0: Выход из программы");
        choice = input.nextInt();
        return choice;
    }
    private static boolean isWork = true;
    public static void run() throws IOException {
        while (isWork) {
            int operation = getOperation();
            switch (operation) {
                case (1) -> addAnimal();
                case (2) -> System.out.println("2"); 
                case (3) -> System.out.println("3");
                case (0) -> isWork = false;
            }
        }
    }
    public static int getAnimal() throws IOException{
        int choice = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Какое животное Вы хотите завести?");
        System.out.println("Добавить кота, нажмите 1");
        System.out.println("Добавить собаку, нажмите 2");
        System.out.println("Добавить хомяка, нажмите 3");
        System.out.println("Добавить лошадь, нажмите 4");
        System.out.println("Добавить верюлюда, нажмите 5");
        System.out.println("Добавить осла, нажмите 6");
        System.out.println("Вернуться в начало программы, нажмите 0");
        choice = input.nextInt();
        return choice;
    }

    public static String getName(){
        Scanner input = new Scanner(System.in);
        String name;
        System.out.println("Введите имя нового животного ");
        name = input.next();
        return name;
    }
    public static LocalDate getBirthday() {
        Scanner input = new Scanner(System.in);
        LocalDate birthday;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Введите дату рождения, в формате yyyy-MM-dd");
        String s = input.next();
        birthday = LocalDate.parse(s, formatter);
        return birthday;
    }

    public static void addAnimal() throws IOException{
        Zoo zoo = new Zoo();
        int operation = getAnimal();
        switch (operation) {
            case (1) -> zoo.addList(new Cat(getName(), getBirthday()));
            case (2) -> zoo.addList(new Dog(getName(), getBirthday()));
            case (3) -> zoo.addList(new Hamster(getName(), getBirthday()));
            case (4) -> zoo.addList(new Horse(getName(), getBirthday()));
            case (5) -> zoo.addList(new Camel(getName(), getBirthday()));
            case (6) -> zoo.addList(new Donkey(getName(), getBirthday()));
            case (0) -> run();
        }

        for (var item : zoo.getListAnimal()) {
            System.out.println(item);
        }    
        for (var item : zoo.walkables()) {
            System.out.printf("%s %s\n", item.toString(), item.walk());
        }      
    }   
}

