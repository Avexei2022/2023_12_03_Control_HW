package model.animalCommand;

import java.io.Serializable;
import java.util.Objects;

public class PetCommand implements ACItemsList, Serializable {

    private final int animal_id;
    private final int command_id;

    public PetCommand (int animal_id, int command_id){
        this.animal_id = animal_id;
        this.command_id = command_id;
    }
    @Override
    public int getAnimalId() {
        return animal_id;
    }

    @Override
    public int getCommandId() {
        return command_id;
    }

    public  boolean equals(Object obj){
        if (this == obj){
            return  true;
        }
        if (!(obj instanceof PetCommand pet_command)){
            return false;
        }
        return Objects.equals(pet_command.getAnimalId(), getAnimalId())
                && Objects.equals(pet_command.getCommandId(), getCommandId());
    }
}
