package animals;

import java.time.LocalDate;

public abstract class PackAnimal extends Animal {
    public PackAnimal(String name, LocalDate birthday) {
        super(name, birthday);
    }
    public String typeAnimal() {
        return "Pack Animal";
    }

    @Override
    public String toString() {
        return String.format("Pack Animal %s", super.toString());
    }

}
