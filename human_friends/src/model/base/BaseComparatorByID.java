package model.base;

import java.util.Comparator;

public class BaseComparatorByID<T extends BaseItemsList> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
