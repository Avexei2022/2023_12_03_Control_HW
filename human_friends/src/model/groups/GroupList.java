package model.groups;

import model.base.Base;
import model.base.BaseList;
import java.util.ArrayList;
import java.util.List;

public class GroupList extends BaseList<Base>  {

    public GroupList(List<Base> group_list) {
        super(group_list);
    }
    public GroupList(){
        this(new ArrayList<>());
    }

}
