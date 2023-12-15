package animals;

import java.time.LocalDate;

public abstract class Pet extends Animal{

    public Pet(String name, LocalDate birthday) {
        super(name, birthday);
    }
    public String typeAnimal() {
        return "Pet";
    }

    @Override
    public String toString() {
        return String.format("Pet | %s", super.toString());
    }

}
