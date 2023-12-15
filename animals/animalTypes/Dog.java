package animals.animalTypes;

import java.time.LocalDate;

import animals.Pet;
import animals.Inteface.BarkAble;
import animals.Inteface.FetchAble;
import animals.Inteface.PawAble;
import animals.Inteface.RollAble;
import animals.Inteface.Sitable;
import animals.Inteface.StayAble;

public class Dog extends Pet implements PawAble, BarkAble, StayAble, FetchAble, Sitable, RollAble {
    public Dog(String name, LocalDate birthday){
        super(name, birthday);
    }

    @Override
    public String toString() {
        return String.format("Dog | %s", super.toString());
    }

    @Override
    public String say() {
        return "Gaw";
    }

    @Override
    public String roll() {
        return "roll";
    }

    @Override
    public String sit() {
        return "sit";
    }

    @Override
    public String fetch() {
        return "fetch";
    }

    @Override
    public String stay() {
        return "stay";
    }

    @Override
    public String bark() {
        return "bark";
    }

    @Override
    public String paw() {
        return "paw";
    }   
}
