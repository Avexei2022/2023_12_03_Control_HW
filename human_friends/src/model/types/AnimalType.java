package model.types;

import model.groups.AnimalGroup;



public class AnimalType extends AnimalGroup implements TypeItemsList{
    private int id;
    protected final int group_id;
     public AnimalType(int group_id, String name){
        super (name);
         id = -1;
        this.group_id = group_id;
    }

    @Override
    public String toString() {
        return getTypeInfo();
    }

    public String getTypeInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(" | Вид: id - ");
        sb.append(id);
        sb.append(", наименование - ");
        sb.append(getName());

        return sb.toString();
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public int getParentId() {
        return group_id;
    }


}
