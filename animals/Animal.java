package animals;

import java.time.LocalDate;

import animals.Inteface.Sayable;

public abstract class Animal implements Sayable {
    private String name;
    private LocalDate birthday; 

    public Animal(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    public String getName(){
        return name;
    }

    public LocalDate getDate(){
        return birthday;
    }
    public void setName(String newName){
        name = newName;
    }

    public void setDate(LocalDate newDate){
        this.birthday = newDate;
    }



    @Override
    public String toString() {
        return String.format("Name: %s | Birthay: %s | say: %s", name, birthday,say());
        //  "Animal{" + "name='" + name + '\'' + ", birthday='" + birthday + '\'' +'}';
    }
    
}