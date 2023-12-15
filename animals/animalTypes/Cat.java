package animals.animalTypes;

import java.time.LocalDate;

import animals.Pet;
import animals.Inteface.Jumpable;
import animals.Inteface.Pounceable;
import animals.Inteface.Sitable;


public class Cat extends Pet implements Jumpable, Sitable, Pounceable {

    public Cat(String name, LocalDate birthday){
        super(name, birthday);
    }

    @Override
    public String toString() {
        return String.format("Cat | %s", super.toString());
    }

    @Override
    public String say() {
        return "Muay";
    }
    @Override
    public String highJump() {
        return "Jump";
    }

    @Override
    public String sit() {
        return "Sit";
    }

    @Override
    public String pounce() {
        return "Pounce";
    }

}
