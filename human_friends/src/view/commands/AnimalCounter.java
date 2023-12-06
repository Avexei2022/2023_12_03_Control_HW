package view.commands;

import view.ConsoleUI;

public class AnimalCounter extends Command{
    public AnimalCounter(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Счетчик питомцев";
    }
    public void execute(){
        consoleUI.counter();
    }
}
