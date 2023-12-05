package presenter;

import model.Service;
import view.ConsoleUI;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public Presenter() {

    }
    public void printAnimalList() {
        String info = service.printAnimalList();
        view.printAnswer(info);
    }

    public void printGroupList() {
        String info = service.printGroupList();
        view.printAnswer(info);
    }
    public void printTypeList() {
        String info = service.printTypeList();
        view.printAnswer(info);
    }

    public void printCommandList() {
        String info = service.printCommandList();
        view.printAnswer(info);
    }

    public void addGroup(String name) {
        String info = service.addGroup(name);
        view.printAnswer(info);
    }

    public void addType(int groupId, String name) {
        String info = service.addType(groupId, name);
        view.printAnswer(info);
    }

    public void addAnimal(int groupId, String name, LocalDate birthday) {
        String info = service.addAnimal(groupId, name, birthday);
        view.printAnswer(info);
    }
    public void addCommand(String name) {
        String info = service.addCommand(name);
        view.printAnswer(info);
    }

    public void trainAnimal(int animalId, int commandId) {
        String info = service.trainAnimal(animalId, commandId);
        view.printAnswer(info);
    }

    public void getInfoPetCommandByAnimalID(int animal_id) {
        String info = service.getInfoPetCommandByAnimalID(animal_id);
        view.printAnswer(info);
    }

    public void counter() {
    }
    public String printDialog(String info){
        return new ConsoleUI().printDialog(info);
    }

    public void print_info(String info) {
        new ConsoleUI().printAnswer(info);
    }

    public boolean checkIsGroup(int group_id) {
        return service.checkIsGroup(group_id);
    }

    public boolean checkIsType(int type_id) {
        return service.checkIsType(type_id);
    }

    public boolean checkIsAnimal(int animal_id) {
        return service.checkIsAnimal(animal_id);
    }

    public boolean checkIsCommand(int command_id) {
        return service.checkIsCommand(command_id);
    }


    public void loadDB() {
    }


    public void getAnimalNameByID(int animalId) {
        String info = service.getAnimalNameByID(animalId);
        view.printAnswer(info);
    }
}
