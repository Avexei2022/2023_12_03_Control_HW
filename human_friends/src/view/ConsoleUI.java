package view;

import model.commands.AnimalCommand;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "\nВы ввели неверное значение\n";
    private final Scanner scanner;
    private final Presenter presenter;
    private boolean work;
    private Menu menu;
    String user_string;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
        user_string = "";
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public String printDialog(String text) {
        System.out.print(text);
        return scanner.nextLine().trim();
    }
    public void run() {
        System.out.println("\nHUMAN FRIENDS. Реестр животных\n");
        while (work){
            System.out.println(menu.printMenu());
            execute();
        }
        System.out.println("\nHUMAN FRIENDS. Программа закрыта.\n");
    }

    private void execute(){
        System.out.print("Введите цифру соответствующего пункта меню: ");
        String string = scanner.nextLine();
        if (checkIntegerInput(string)){
            int numCommand = Integer.parseInt(string);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }


    private boolean checkCommand(int numCommand){
        int size = menu.getSize();
        if (numCommand <= size && numCommand > 0){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void exit() {
        work = false;
    }

    public void printAnimalList() {
        presenter.printAnimalList();
    }

    public void printAnimalCommands() {
        presenter.printCommandList();
    }

    public void addGroup() {
        presenter.printGroupList();
        System.out.println("\nВвод новой группы животных.");
        String name = checkAlphabeticInput("наименование группы");
        presenter.addGroup(name);
        presenter.printGroupList();
    }

    public void addType() {
        presenter.printTypeList();
        System.out.println("\nВвод нового вида животных.");
        int group_id = getGroupID();
        if (group_id < 0){
            System.out.println("\nОперация ввода нового вида животных прервана.\n");
        } else {
            String name = checkAlphabeticInput("Введите наименование вида" );
            presenter.addType(group_id, name);
            presenter.printTypeList();
        }
    }

    public void addAnimal() {
        presenter.printAnimalList();
        System.out.println("\nВвод нового животного.");
        int type_id = getTypeID();
        if (type_id < 0) {
            System.out.println("\nОперация ввода нового животного прервана.\n");
        } else {
            String name = checkAlphabeticInput("Введите имя ");
            LocalDate birthday = checkFormatLocalDate("Введите дату рождения (dd.mm.yyyy): ");
            presenter.addAnimal(type_id, name, birthday);
            presenter.printAnimalList();
        }
    }


    public void addCommand() {
        presenter.printCommandList();
        System.out.println("\nВвод новой команды, выполняемой животными.");
        String name = checkAlphabeticInput("наименование команды");
        presenter.addCommand(name);
        presenter.printCommandList();
    }

    private int getGroupID(){
        boolean flag = true;
        int group_id = -1;
        while (flag) {
            presenter.printGroupList();
            System.out.print("\nВведите ID группы животных: ");
            String string = scanner.nextLine();
            if (checkIntegerInput(string)) {
                group_id = Integer.parseInt(string);
                if (checkIsGroup(group_id)) {
                    flag = false;
                } else {
                    System.out.print("\nГруппы животных с таким ID в списке нет.\n");
                    group_id = -1;
                    flag = false;
                }
            }
        }
        return group_id;
    }

    private int getTypeID(){
        boolean flag = true;
        int type_id = -1;
        while (flag) {
            presenter.printTypeList();
            System.out.print("\nВведите ID вида животных: ");
            String string = scanner.nextLine();
            if (checkIntegerInput(string)) {
                type_id = Integer.parseInt(string);
                if (checkIsType(type_id)) {
                    flag = false;
                } else {
                    System.out.print("\nВида животных с таким ID в списке нет.\n");
                    type_id = -1;
                    flag = false;
                }
            }
        }
        return type_id;
    }
    private boolean checkIsGroup(int group_id){
        return presenter.checkIsGroup(group_id);
    }

    private boolean checkIsType(int type_id){
        return presenter.checkIsType(type_id);
    }

    public void trainAnimal() {
        presenter.trainAnimal();
    }

    public void counter() {
        presenter.counter();
    }

    private boolean checkIntegerInput(String string){
        if (string.matches("\\d+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private String checkAlphabeticInput(String message){
        String name = "";
        boolean flag = true;
        while (flag) {
            System.out.print("\n" + message + ": ");
            name = scanner.nextLine().trim();
            if (name.matches("[\\p{L}| ]+")){
                flag = false;
            } else {
                System.out.println("\nВ названии следует использовать буквы!\n");
            }
        }
        return name;
    }

    public LocalDate checkFormatLocalDate(String message) {
        boolean flag = true;
        String date = "01.01.9999";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate local_date = LocalDate.parse(date, formatter);
        while (flag) {
            System.out.print("\n" + message + ": ");
            try {
                local_date = LocalDate.parse(scanner.nextLine().trim(), formatter);
                flag = false;
            } catch (Exception e) {
                inputError();
            }
        }
        return local_date;
    }

    public void LoadDB() {
        presenter.loadDB();
    }

}