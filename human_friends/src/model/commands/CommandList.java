package model.commands;

import model.base.Base;
import model.base.BaseList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommandList extends BaseList<Base> implements Serializable {

    public CommandList(List<Base> command_list) {
        super(command_list);
    }
    public CommandList(){
        this(new ArrayList<>());
    }
}
