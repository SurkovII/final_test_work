package animals.animalTypes;

import java.time.LocalDate;

import animals.Pet;
import animals.Inteface.HideAble;
import animals.Inteface.RollAble;
import animals.Inteface.SpinAble;

public class Hamster extends Pet implements RollAble, HideAble, SpinAble {

    public Hamster(String name, LocalDate birthday) {
        super(name, birthday);
        
    }

    @Override
    public String say() {
        return "pi-pi-pi";
    }

    @Override
    public String roll() {
        return "roll";
    }

    @Override
    public String spin() {
        return "spin";
    }

    @Override
    public String hide() {
        return "hide";
    }

    @Override
    public String toString() {
        return String.format("Hamster | %s", super.toString());
    }
    
}
