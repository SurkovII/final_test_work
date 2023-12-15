package animals.animalTypes;

import java.time.LocalDate;

import animals.PackAnimal;
import animals.Inteface.BrayAble;
import animals.Inteface.Carry_Loadable;
import animals.Inteface.Walkable;

public class Donkey extends PackAnimal implements Walkable, Carry_Loadable, BrayAble, KickAble {

    public Donkey(String name, LocalDate birthday) {
        super(name, birthday);
    }

    @Override
    public String say() {
        return "I-a I-a";
    }

    @Override
    public String bray() {
        return "bray";
    }

    @Override
    public String carry_load() {
        return "carry load";
    }

    @Override
    public String walk() {
        return "walk";
    }
    
}
