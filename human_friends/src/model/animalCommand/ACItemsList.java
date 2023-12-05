package model.animalCommand;

import java.io.Serializable;

public interface ACItemsList extends Serializable {
    int getAnimalId();
    void setAnimalId(int animal_id);
    int getCommandId();
    void setCommandId(int command_id);
}
