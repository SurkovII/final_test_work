package animals.animalTypes;

import java.time.LocalDate;

import animals.PackAnimal;
import animals.Inteface.Carry_Loadable;
import animals.Inteface.Runable;
import animals.Inteface.Sitable;
import animals.Inteface.Walkable;

public class Camel extends PackAnimal implements Walkable, Carry_Loadable, Sitable, Runable {

    public Camel(String name, LocalDate birthday) {
        super(name, birthday);
    }

    @Override
    public String walk() {
        return "walk";
    }

    @Override
    public String sit() {
        return "sit";
    }

    @Override
    public String run() {
        return "run";
    }

    @Override
    public String say() {
        return "Rrrrrr";
    }

    @Override
    public String carry_load() {
        return "carry load";
    }
    
}
