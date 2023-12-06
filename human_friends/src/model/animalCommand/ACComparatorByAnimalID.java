package model.animalCommand;

import java.util.Comparator;

public class ACComparatorByAnimalID<T extends ACItemsList> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAnimalId(), o2.getAnimalId());
    }

}
