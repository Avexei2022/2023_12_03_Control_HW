package view.commands;

import view.ConsoleUI;

public class AddCommand extends Command{
    public AddCommand(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить новую команду в список команд";
    }

    public void execute(){
        consoleUI.addCommand();
    }
}
