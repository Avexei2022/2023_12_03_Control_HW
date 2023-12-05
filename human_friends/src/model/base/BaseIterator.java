package model.base;

import java.util.Iterator;
import java.util.List;

public class BaseIterator<E> implements Iterator<E> {
    private int index;

    private final List<E> baseList;

    public BaseIterator(List<E> baseList) {
        this.baseList = baseList;
    }

    @Override
    public boolean hasNext() {
        return baseList.size() > index;
    }

    @Override
    public E next() {
        return baseList.get(index++);
    }
}
