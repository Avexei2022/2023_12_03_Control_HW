package view.commands;

import view.ConsoleUI;

public class Exit extends Command{
    public Exit(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выход из программы";
    }
    public void execute() {
        consoleUI.exit();
    }
}
