package model.animals;

import model.base.Base;
import model.base.BaseList;

import java.util.ArrayList;
import java.util.List;

public class AnimalList extends BaseList<Base> {
    public AnimalList(List<Base> animal_list) {
        super(animal_list);
    }
    public AnimalList(){
        this(new ArrayList<>());
    }
}

