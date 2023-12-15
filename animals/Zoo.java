package animals;
import java.util.ArrayList;
import java.util.List;

import animals.Inteface.Jumpable;
import animals.Inteface.Sayable;
import animals.Inteface.Walkable;


public class Zoo {
    private List<Animal> listAnimal = new ArrayList<>();
    
    public List<Animal> getListAnimal() {
        return listAnimal;
    }

    public Zoo addList(Animal animal) {
        listAnimal.add(animal);        
        return this;
    }
    public List<Sayable> getSayble() {
        List<Sayable> sayables = new ArrayList<>();
        for (var item : listAnimal) {
            sayables.add(item);
        }
        return sayables;
    }

    public List<Walkable> walkables() {
        List<Walkable> walkables = new ArrayList<>();
        for (var item : listAnimal) {
            if (item instanceof Walkable) {
                walkables.add((Walkable) item);
            }
        }
        return walkables;
    }
    public List<Jumpable> jupmables() {
        List<Jumpable> jumpables = new ArrayList<>();
        for (var item : listAnimal) {
            if (item instanceof Jumpable) {
                jumpables.add((Jumpable) item);
            }
        }
        return jumpables;
    }

}