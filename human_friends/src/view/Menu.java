package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Command> commandList;
    public Menu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
        commandList.add(new PrintAnimalList(consoleUI));
        commandList.add(new AddAnimal(consoleUI));
        commandList.add(new ShowCommands(consoleUI));
        commandList.add(new AnimalTrainNewCommand(consoleUI));
        commandList.add(new AnimalCounter(consoleUI));
        commandList.add(new AddCommand(consoleUI));
        commandList.add(new AddType(consoleUI));
        commandList.add(new AddGroup(consoleUI));
        commandList.add(new SaveDB(consoleUI));
        commandList.add(new LoadDB(consoleUI));
        commandList.add(new Exit(consoleUI));
    }
    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню:\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int choice){
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
