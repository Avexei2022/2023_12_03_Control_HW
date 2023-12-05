package view.commands;

import view.ConsoleUI;

public class AnimalTrainNewCommand extends Command{
    public AnimalTrainNewCommand(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Обучить животное новой команде";
    }
    public void execute(){
        consoleUI.trainAnimal();
    }
}
