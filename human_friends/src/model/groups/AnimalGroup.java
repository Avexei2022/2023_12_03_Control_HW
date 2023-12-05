package model.groups;

import model.base.Base;

import java.io.Serializable;


public class AnimalGroup extends Base implements Serializable {
    private int id;


    public AnimalGroup(String name){
        super(name);

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return getInfoGroup();
    }

     public String getInfoGroup() {
        StringBuilder sb = new StringBuilder();
        sb.append("Группа: id - ");
        sb.append(id);
        sb.append(", наименование - ");
        sb.append(getName());
        return sb.toString();
    }

}
