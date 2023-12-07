package model;

import model.animalCommand.ACList;
import model.animalCommand.PetCommand;
import model.animals.Animal;
import model.animals.AnimalList;
import model.base.Base;
import model.commands.BaseCommand;
import model.commands.CommandList;
import model.groups.AnimalGroup;
import model.groups.GroupList;
import model.counter.Counter;
import model.types.AnimalType;
import model.types.TypeList;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class HumanFriendsDB implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final GroupList group_list;
    private final TypeList type_list;
    private final AnimalList animal_list;
    private final CommandList command_list;
    private final ACList<PetCommand> ac_list;
    private final Counter pets_count;
    public HumanFriendsDB(){
        group_list = new GroupList();
        type_list = new TypeList();
        animal_list = new AnimalList();
        command_list = new CommandList();
        ac_list = new ACList<>();
        pets_count = new Counter();
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
            pets_count.increment();
            info = "\n Вид: " + name + " добавлен в список.\n";
        } else {
            info =  "\n Вид:  " + name + " уже существует в списке.\n";
        }
        return info;
    }

    public String addCommand(String name) {
        BaseCommand base_command = new BaseCommand(name);
        String info;
        if (command_list.addBaseToList(base_command)){
            info = "\n Команда: " + name + " добавлена в список.\n";
        } else {
            info =  "\n Команда: " + name + " уже существует в списке.\n";
        }
        return info;
    }

    public String trainAnimal(int animal_id, int command_id) {
        PetCommand pet_command = new PetCommand(animal_id, command_id);
        String animal_name = animal_list.getNameById(animal_id);
        String command_name = command_list.getNameById(command_id);
        String info;
        if (ac_list.addACToList(pet_command)){
            info = "\n Питомец " + animal_name + " обучен команде " + command_name + ".\n";
        } else {
            info =  "\n Питомец " + animal_name + " уже был обучен команде " + command_name + ".\n";
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
    public String printAnimalList(int id1_bd2) {
        if (id1_bd2 == 1) {
            animal_list.sortListById();
        } else {
            animal_list.sortListByBirthday();
        }
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

    public boolean checkIsAnimal(int animal_id) {
        return animal_list.checkIsId(animal_id);
    }

    public boolean checkIsCommand(int command_id) {
        return command_list.checkIsId(command_id);
    }

    public boolean checkCommandIsEmpty() {
        return command_list.checkIsEmpty();
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

    public String getInfoAnimalList() {
        if (animal_list.checkIsEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("\nСписок животных.\n");
            for (Animal animal : animal_list) {
                sb.append(group_list.getById(((AnimalType) type_list
                                .getById(animal.getParentId())).getParentId())
                        .toString());
                sb.append(type_list.getById(animal.getParentId())
                        .toString());
                sb.append(animal);
                sb.append(" | Обучен командам: ");
                sb.append(getInfoPetCommandByAnimalID(animal.getId()));
                sb.append("\n");
            }
            return sb.toString();
        } else {
            return "\nСписок животных пуст.\n";
        }
    }
    public String getInfoCommandList() {
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

    public String getInfoPetCommandByAnimalID(int animal_id){
        List<Integer> pet_command_list = ac_list.getByAnimalId(animal_id);
        StringBuilder sb = new StringBuilder();
        for (Integer i: pet_command_list) {
            sb.append(command_list.getNameById(i));
            sb.append(" ");
        }
        return sb.toString();
    }

    public String getAnimalNameByID(int animal_id) {
        return animal_list.getNameById(animal_id);
    }

    public String counter() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nУ вас ");
        sb.append(pets_count.getPetsCount());
        sb.append(" питомцев.\n");
        return sb.toString();
    }
}
