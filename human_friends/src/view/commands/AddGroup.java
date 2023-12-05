package view.commands;

import view.ConsoleUI;

public class AddGroup extends Command{
    public AddGroup(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить новую группу животных";
    }
    public void execute(){
        consoleUI.addGroup();
    }
}
