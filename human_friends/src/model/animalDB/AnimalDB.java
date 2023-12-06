package model.animalDB;

import model.animalCommand.ACList;
import model.animalCommand.PetCommand;
import model.animals.AnimalList;
import model.commands.CommandList;
import model.groups.GroupList;
import model.infrastructure.Counter;
import model.types.TypeList;

import java.io.Serializable;

public class AnimalDB implements Serializable {
    protected final GroupList group_list;
    protected final TypeList type_list;
    protected final AnimalList animal_list;
    protected final CommandList command_list;
    protected final ACList<PetCommand> ac_list;
    protected final Counter pets_count;

    public AnimalDB() {
        group_list = new GroupList();
        type_list = new TypeList();
        animal_list = new AnimalList();
        command_list = new CommandList();
        ac_list = new ACList<>();
        pets_count = new Counter();
    }
}
