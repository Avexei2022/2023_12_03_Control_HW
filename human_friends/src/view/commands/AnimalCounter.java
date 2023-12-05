package view.commands;

import view.ConsoleUI;

public class AnimalCounter extends Command{
    public AnimalCounter(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Счетчик животных";
    }
    public void execute(){
        consoleUI.counter();
    }
}
