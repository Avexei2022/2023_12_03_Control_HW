package view;

import model.exception_app.ThisAppException;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "\nВы ввели неверное значение\n";
    private static final String file_name = "HumanFriends.mydb";
    private final Scanner scanner;
    private final Presenter presenter;
    private boolean work;
    private final Menu menu;
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

    public void printAnimalList(int id1_bd2) {
        presenter.printAnimalList(id1_bd2);
    }

    public void printAnimalCommands() {
        if (presenter.checkAnimalListIsNotEmpty()) {
            System.out.println("\nПолучить информацию о командах, выполняемых питомцем.");
            int animal_id = getAnimalID();
            if (animal_id < 0) {
                System.out.println(" Введены неверные данные о питомце. Операция прервана.\n");
            } else {
                System.out.println("Питомец: ");
                presenter.getAnimalNameByID(animal_id);
                System.out.println("Обучен командам: ");
                presenter.getInfoPetCommandByAnimalID(animal_id);
                System.out.println(" ");
            }
        } else {
            System.out.println("Реестр не содержит питомцев, заведите их.");
        }
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
        presenter.printAnimalList(1);
        if (presenter.checkTypeListIsNotEmpty()) {
            System.out.println("\nВвод информации о новом питомце.");
            int type_id = getTypeID();
            if (type_id < 0) {
                System.out.println("\nОперация ввода нового питомца прервана.\n");
            } else {
                String name = checkAlphabeticInput("Введите имя ");
                LocalDate birthday = checkFormatLocalDate("Введите дату рождения (dd.mm.yyyy): ");
                presenter.addAnimal(type_id, name, birthday);
                presenter.printAnimalList(1);
            }
        } else {
            System.out.println("Список видов животных пуст. Заполните его.");
        }
    }

    public void addCommand() {
        presenter.printCommandList();
        System.out.println("\nВвод новой команды, выполняемой питомцами.");
        String name = checkAlphabeticInput("Введите наименование команды");
        presenter.addCommand(name);
        presenter.printCommandList();
    }

    public void trainAnimal() {
        if (checkCommandIsEmpty()){
            String s_stop_train = "Операция обучения питомца прервана.\n";
            String s_error_value = "\nВведены неверные данные о ";
            System.out.println("\nОбучить питомца новой команде.");
            int animal_id = getAnimalID();
            if (animal_id < 0) {
                System.out.println(s_error_value + "питомце. " + s_stop_train);
            } else {
                int command_id = getCommandID();
                if (command_id < 0) {
                    System.out.println(s_error_value + "команде. " + s_stop_train);
                } else {
                    presenter.trainAnimal(animal_id, command_id);
                }
            }
        } else {
            System.out.println("Список команд пуст, вначале заполните его, выбрав соответствующий пункт меню");
        }
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

    private int getAnimalID(){
        boolean flag = true;
        int animal_id = -1;
        while (flag) {
            presenter.printAnimalList(1);
            System.out.print("\nВведите ID питомца: ");
            String string = scanner.nextLine();
            if (checkIntegerInput(string)) {
                animal_id = Integer.parseInt(string);
                if (checkIsAnimal(animal_id)) {
                    flag = false;
                } else {
                    System.out.print("\nПитомца с таким ID в списке нет.\n");
                    animal_id = -1;
                    flag = false;
                }
            }
        }
        return animal_id;
    }

    private int getCommandID(){
        boolean flag = true;
        int command_id = -1;
        while (flag) {
            presenter.printCommandList();
            System.out.print("\nВведите ID команды: ");
            String string = scanner.nextLine();
            if (checkIntegerInput(string)) {
                command_id = Integer.parseInt(string);
                if (checkIsCommand(command_id)) {
                    flag = false;
                } else {
                    System.out.print("\nКоманды с таким ID в списке нет.\n");
                    command_id = -1;
                    flag = false;
                }
            }
        }
        return command_id;
    }
    private boolean checkIsGroup(int group_id){
        return presenter.checkIsGroup(group_id);
    }

    private boolean checkIsType(int type_id){
        return presenter.checkIsType(type_id);
    }

    private boolean checkIsAnimal(int animal_id){
        return presenter.checkIsAnimal(animal_id);
    }

    private boolean checkIsCommand(int command_id){
        return presenter.checkIsCommand(command_id);
    }

    private boolean checkCommandIsEmpty(){
        return presenter.checkCommandIsEmpty();
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

    public void counter() {
        presenter.counter();
    }
    public void loadDB() {
        try {
            System.out.print("""

                    Загрузка базы данных из файла: """ + file_name + """
                    \nТекущая база данных будет удалена.
                    Для подтверждения введите "Yes":\s""");
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("Yes")) {
                presenter.loadDB(file_name);
            } else {
                System.out.println("Действие отменено.");
            }
        } catch (ThisAppException e) {
            System.out.println(e.getMessage());
        }

    }

    public void saveDB() {
        try {
            System.out.print("""

                    Сохранение базы данных в файл """ + file_name + """
                    \nПредыдущие данные будут удалены.
                    Для подтверждения введите "Yes":\s""");
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("Yes")) {
                System.out.println("Сохраняю базу данных в файл.\n");
                presenter.saveDB(file_name);
            } else {
                System.out.println("\nДействие отменено.\n");
            }
        } catch (ThisAppException e) {
            System.out.println(e.getMessage());
        }
    }

}
