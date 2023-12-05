package view.commands;

import view.ConsoleUI;

public class AddType extends Command{
    public AddType(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить новый вид животных";
    }
    public void execute(){
        consoleUI.addType();
    }
}
