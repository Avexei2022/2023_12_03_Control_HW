package model.animalCommand;

import java.util.Iterator;
import java.util.List;

public class ACIterator<E> implements Iterator<E> {
    private int index;
    private final List<E> ac_list;

    public ACIterator(List<E> ac_list) {
        this.ac_list = ac_list;
    }
    @Override
    public boolean hasNext(){
        return ac_list.size() > index;
    }

    @Override
    public E next(){
        return ac_list.get(index++);
    }
}
