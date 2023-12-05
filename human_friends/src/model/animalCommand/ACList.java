package model.animalCommand;

import model.base.BaseComparatorByID;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ACList <E extends ACItemsList> implements Serializable, Iterable {
    private final List<E> ac_list;
    public ACList(List<E> ac_list){
        this.ac_list = ac_list;
    }
    public boolean addACToList(E e){
        if (e == null){
            return false;
        }
        if (!ac_list.contains(e)){
            ac_list.add(e);
            return true;
        }
        return false;
    }

    public List<E> getByAnimalId(int animal_id){
        List<E> command_list_by_animal_id = new ArrayList<>();
        for (E ac : ac_list){
            if (ac.getAnimalId() == animal_id){
                command_list_by_animal_id.add(ac);
            }
        }
        return command_list_by_animal_id;
    }
    public List<E> getByCommandId(int command_id){
        List<E> animal_list_by_animal_id = new ArrayList<>();
        for (E ac : ac_list){
            if (ac.getAnimalId() == command_id){
                animal_list_by_animal_id.add(ac);
            }
        }
        return animal_list_by_animal_id;
    }

    public boolean checkIsEmpty(){
        return !ac_list.isEmpty();
    }

    public void sortListByAnimalId(){
        ac_list.sort(new ACComparatorByAnimalID<>());
    }

    public void sortListByCommandId(){
        ac_list.sort(new ACComparatorByCommandID<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new ACIterator<>(ac_list);
    }
}
