package view.commands;

import view.ConsoleUI;

public class SaveDB extends Command{
    public SaveDB(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сохранить базу данных";
    }
    public void execute(){
        consoleUI.saveDB();
    }
}
