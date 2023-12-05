package model.types;

import model.base.Base;
import model.base.BaseList;
import java.util.ArrayList;
import java.util.List;

public class TypeList extends BaseList<Base> {


    public TypeList(List<Base> type_list) {
        super(type_list);
    }
    public TypeList(){
        this(new ArrayList<>());
    }

}
