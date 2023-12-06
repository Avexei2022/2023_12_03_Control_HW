package model.animals;

import java.util.Comparator;


public class AnimalComparatorByBirthday <T extends Animal> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
