package model.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public abstract class BaseList <E extends Base> implements Serializable, Iterable<E>{
    protected int id;
    protected List<E> base_list;
    public BaseList(List<E> base_list) {
        this.base_list = base_list;
    }
    public boolean addBaseToList(E e){
        if (e == null){
            return false;
        }
        if (!base_list.contains(e)){
            base_list.add(e);
            e.setId(id++);
            return true;
        }
        return false;
    }

    public E getById(int id){
        for (E base : base_list){
            if (base.getId() == id){
                return base;
            }
        }
        return null;
    }

    public String getNameById(int id){
        for (E base : base_list){
            if (base.getId() == id){
                return base.getName();
            }
        }
        return null;
    }

    public boolean checkIsId(int id){
        for (E base : base_list){
            if (base.getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean checkIsNotEmpty(){
        return !base_list.isEmpty();
    }

    public void sortListById(){
        base_list.sort(new BaseComparatorByID<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new BaseIterator<>(base_list);
    }

}
