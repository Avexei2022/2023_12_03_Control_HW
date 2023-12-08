package model.animalCommand;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ACList<E extends PetCommand> implements Serializable, Iterable<E> {
    private final List<E> ac_list;
    public ACList(List<E> ac_list){
        this.ac_list = ac_list;
    }

    public ACList(){
        this(new ArrayList<>());
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

    public List<Integer> getByAnimalId(int animal_id){
        List<Integer> command_list_by_animal_id = new ArrayList<>();
        for (E e : ac_list){
            if (e.getAnimalId() == animal_id){
                command_list_by_animal_id.add(e.getCommandId());
            }
        }
        return command_list_by_animal_id;
    }

    @Override
    public Iterator<E> iterator() {
        return new ACIterator<>(ac_list);
    }

}
