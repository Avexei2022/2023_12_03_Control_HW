package model;

import model.animals.Animal;
import model.animals.AnimalList;
import model.base.Base;
import model.commands.AnimalCommand;
import model.commands.CommandList;
import model.groups.AnimalGroup;
import model.groups.GroupList;
import model.types.AnimalType;
import model.types.TypeList;

import java.time.LocalDate;

public class Service {
    private final GroupList group_list;
    private final TypeList type_list;
    private final AnimalList animal_list;
    private final CommandList command_list;
    public Service (){
        group_list = new GroupList();
        type_list = new TypeList();
        animal_list = new AnimalList();
        command_list = new CommandList();
    }

    public String addGroup(String name) {
        AnimalGroup animal_group = new AnimalGroup(name);
        String info;
        if (group_list.addBaseToList(animal_group)){
            info = "\n Группа: " + name + " добавлена в список.\n";
        } else {
            info =  "\n Группа: " + name + " уже существует в списке.\n";
        }
        return info;
    }

    public String addType(int groupId, String name) {
        AnimalType animal_type = new AnimalType(groupId, name);
        String info;
        if (type_list.addBaseToList(animal_type)){
            info = "\n Вид: " + name + " добавлен в список.\n";
        } else {
            info =  "\n Вид:  " + name + " уже существует в списке.\n";
        }
        return info;
    }

    public String addAnimal(int groupId, String name, LocalDate birthday) {
        Animal animal = new Animal(groupId, name, birthday);
        String info;
        if (animal_list.addBaseToList(animal)){
            info = "\n Вид: " + name + " добавлен в список.\n";
        } else {
            info =  "\n Вид:  " + name + " уже существует в списке.\n";
        }
        return info;
    }

    public String addCommand(String name) {
        AnimalCommand animal_command = new AnimalCommand(name);
        String info;
        if (command_list.addBaseToList(animal_command)){
            info = "\n Команда: " + name + " добавлена в список.\n";
        } else {
            info =  "\n Команда: " + name + " уже существует в списке.\n";
        }
        return info;
    }
    public String printGroupList() {
        group_list.sortListById();
        return getInfoGroupList();
    }

    public String printTypeList() {
        type_list.sortListById();
        return getInfoTypeList();
    }
    public String printAnimalList() {
        type_list.sortListById();
        return getInfoAnimalList();
    }

     public String printCommandList() {
        command_list.sortListById();
        return getInfoCommandList();
    }


    public boolean checkIsGroup(int group_id) {
        return group_list.checkIsId(group_id);
    }

    public boolean checkIsType(int type_id) {
        return type_list.checkIsId(type_id);
    }

    public String getInfoGroupList() {
        if (group_list.checkIsEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("\nСписок групп животных.\n");
            for (Base e: group_list) {
                sb.append(e.toString());
                sb.append("\n");
            }
            return sb.toString();
        } else {
            return "\nСписок групп животных пуст.\n";
        }
    }

    public String getInfoTypeList() {
        if (type_list.checkIsEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("\nСписок видов животных.\n");
            for (Base type : type_list) {
                sb.append(group_list.getById(((AnimalType) type).getParentId())
                        .toString());
                sb.append(type);
                sb.append("\n");
            }
            return sb.toString();
        } else {
            return "\nСписок видов животных пуст.\n";
        }
    }

    private String getInfoAnimalList() {
        if (animal_list.checkIsEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("\nСписок животных.\n");
            for (Base animal : animal_list) {
                sb.append(group_list.getById(((AnimalType) type_list
                                .getById(((Animal) animal).getParentId())).getParentId())
                        .toString());
                sb.append(type_list.getById(((Animal) animal).getParentId())
                        .toString());
                sb.append(animal);
                sb.append("\n");
            }
            return sb.toString();
        } else {
            return "\nСписок животных пуст.\n";
        }
    }
    private String getInfoCommandList() {
        if (command_list.checkIsEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("\nСписок команд животных.\n");
            for (Base e: command_list) {
                sb.append(e.toString());
                sb.append("\n");
            }
            return sb.toString();
        } else {
            return "\nСписок команд животных пуст.\n";
        }
    }


}