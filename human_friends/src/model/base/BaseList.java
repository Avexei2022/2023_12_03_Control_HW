package model.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public abstract class BaseList <E extends Base> implements Serializable, Iterable<E>{
    private int id;
    private final List<E> base_list;
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

    // TODO: 04.12.2023  
//    public boolean removeBase(E e){
//        if (e == null){
//            return false;
//        }
//        if (baseListE.contains(e)){
//            baseListE.remove(e);
//            return true;
//        }
//        return false;
//    }
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

    // TODO: 04.12.2023  
//    public int getSize() {
//        int size = 0;
//        if (!baseListE.isEmpty()){
//            size = baseListE.size();
//        }
//        return size;
//    }

    public boolean checkIsEmpty(){
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
