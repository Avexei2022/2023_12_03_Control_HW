package model.animalCommand;

import java.util.Comparator;

public class ACComparatorByCommandID<T extends ACItemsList> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getCommandId(), o2.getCommandId());
    }
}
