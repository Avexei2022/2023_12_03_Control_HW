package model.commands;

import model.base.Base;

import java.io.Serializable;

public class BaseCommand extends Base implements Serializable {
    private int id;

    public BaseCommand(String name){
        super(name);

    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getGroupInfo();
    }

    public String getGroupInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Команда: id - ");
        sb.append(id);
        sb.append(", наименование - ");
        sb.append(getName());
        return sb.toString();
    }
}
