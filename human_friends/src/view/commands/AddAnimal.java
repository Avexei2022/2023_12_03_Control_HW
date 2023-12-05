package view.commands;

import view.ConsoleUI;

public class AddAnimal extends Command {
    public AddAnimal(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Завести питомца - добавить новое животное в реестр";
    }
    public void execute(){
        consoleUI.addAnimal();
    }
}
