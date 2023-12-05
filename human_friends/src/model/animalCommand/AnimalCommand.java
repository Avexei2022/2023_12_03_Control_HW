package model.animalCommand;

public class AnimalCommand {
    private int animal_id;
    private int command_id;


    public AnimalCommand(int animal_id, int command_id){
        this.animal_id = animal_id;
        this.command_id = command_id;
    }

    public int getCommand_id() {
        return command_id;
    }

    public void setCommand_id(int command_id) {
        this.command_id = command_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
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
