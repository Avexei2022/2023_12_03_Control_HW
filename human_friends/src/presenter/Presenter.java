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

    public void trainAnimal() {
    }

    public void counter() {
    }
    public String printDialog(String info){
        return new ConsoleUI().printDialog(info);
    }

    public void print_info(String info) {
        new ConsoleUI().printAnswer(info);
    }

    public boolean checkIsGroup(int groupId) {
        return service.checkIsGroup(groupId);
    }

    public boolean checkIsType(int typeId) {
        return service.checkIsType(typeId);
    }


    public void loadDB() {
    }


}
