package model.animals;

import model.commands.AnimalCommand;
import model.types.AnimalType;
import java.time.LocalDate;
import java.util.List;

public class Animal extends AnimalType implements AnimalItemsList{
    private int id;
    private LocalDate birthday;

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
        sb.append(" | Животное: id - ");
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

    public void setBirthday(LocalDate birthday){
        this.birthday = birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
