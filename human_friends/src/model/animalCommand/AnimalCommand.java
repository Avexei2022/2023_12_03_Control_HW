package model.animalCommand;

import java.io.Serializable;

public class AnimalCommand implements ACItemsList, Serializable {
    private int animal_id;
    private int command_id;


    public AnimalCommand(int animal_id, int command_id){
        this.animal_id = animal_id;
        this.command_id = command_id;
    }

    public int getCommandId() {
        return command_id;
    }

    public void setCommandId(int command_id) {
        this.command_id = command_id;
    }

    public int getAnimalId() {
        return animal_id;
    }

    public void setAnimalId(int animal_id) {
        this.animal_id = animal_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalCommand that = (AnimalCommand) o;
        return animal_id == that.animal_id && command_id == that.command_id;
    }


}
