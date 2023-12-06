package model.groups;

import model.base.Base;
import model.base.BaseList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupList extends BaseList<Base>  implements Serializable {

    public GroupList(List<Base> group_list) {
        super(group_list);
    }
    public GroupList(){
        this(new ArrayList<>());
    }

}
