package model.animals;

import model.types.AnimalType;

import java.io.Serializable;
import java.time.LocalDate;

public class Animal extends AnimalType implements AnimalItemsList, Serializable {
    private int id;
    private final LocalDate birthday;

    public Animal(int type_id, String name, LocalDate birthday) {
        super(type_id, name);
        id = -1;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return getAnimalInfo();
    }

    public String getAnimalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(" | Питомец: id - ");
        sb.append(id);
        sb.append(", имя - ");
        sb.append(getName());
        sb.append(", Дата рождения - ");
        sb.append(getBirthday());
        return sb.toString();
    }

    public LocalDate getBirthday(){
        return birthday;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
