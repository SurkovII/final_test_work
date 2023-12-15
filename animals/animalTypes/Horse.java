package animals.animalTypes;

import java.time.LocalDate;

import animals.PackAnimal;
import animals.Inteface.GallopAble;
import animals.Inteface.GanterAble;
import animals.Inteface.TrotAble;

public class Horse extends PackAnimal implements TrotAble, GanterAble, GallopAble {

    public Horse(String name, LocalDate birthday) {
        super(name, birthday);
    }

    @Override
    public String toString() {
        return String.format("Horse | %s", super.toString());
    }

    @Override
    public String say() {
        return "I-go-go";
    }

    @Override
    public String ganter() {
        return "ganter";
    }

    @Override
    public String trot() {
        return "trot";
    }

    @Override
    public String gallop() {
        return "gallop";
    }
    
}
