package view.commands;

import view.ConsoleUI;

public class ShowCommands extends Command{
    public ShowCommands(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывод списка каманд выбранного животного";
    }
    public void execute(){
        consoleUI.printAnimalCommands();
    }
}
