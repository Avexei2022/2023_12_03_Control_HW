package view.commands;

import view.ConsoleUI;

public class LoadDB extends Command{
    public LoadDB(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить базу данных";
    }
    public void execute(){
        consoleUI.loadDB();
    }
}
