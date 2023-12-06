package model.animals;


import model.base.BaseList;
import java.util.ArrayList;
import java.util.List;

public class AnimalList extends BaseList<Animal> {

     public AnimalList(List<Animal> base_list) {
        super(base_list);
    }
    public AnimalList(){
        this(new ArrayList<>());
    }

    public void sortListByBirthday(){
        base_list.sort(new AnimalComparatorByBirthday<>());
    }

}

