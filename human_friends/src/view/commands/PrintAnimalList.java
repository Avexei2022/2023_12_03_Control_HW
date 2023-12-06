package view.commands;

import view.ConsoleUI;

public class PrintAnimalList extends Command {

    public PrintAnimalList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список животных по дате рождения";
    }
    public void execute(){
        consoleUI.printAnimalList(2);
    }

}
