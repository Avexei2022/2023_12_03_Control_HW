package presenter;

import model.AnimalDB;
import view.View;

import java.io.*;
import java.time.LocalDate;

public class Presenter {
    private final View view;
    private AnimalDB animal_db;

    public Presenter(View view) {
        this.view = view;
        this.animal_db = new AnimalDB();
    }

    public void printAnimalList(int id1_bd2) {
        String info = animal_db.printAnimalList(id1_bd2);
        view.printAnswer(info);
    }

    public void printGroupList() {
        String info = animal_db.printGroupList();
        view.printAnswer(info);
    }
    public void printTypeList() {
        String info = animal_db.printTypeList();
        view.printAnswer(info);
    }

    public void printCommandList() {
        String info = animal_db.printCommandList();
        view.printAnswer(info);
    }

    public void addGroup(String name) {
        String info = animal_db.addGroup(name);
        view.printAnswer(info);
    }

    public void addType(int groupId, String name) {
        String info = animal_db.addType(groupId, name);
        view.printAnswer(info);
    }

    public void addAnimal(int groupId, String name, LocalDate birthday) {
        String info = animal_db.addAnimal(groupId, name, birthday);
        view.printAnswer(info);
    }
    public void addCommand(String name) {
        String info = animal_db.addCommand(name);
        view.printAnswer(info);
    }

    public void trainAnimal(int animalId, int commandId) {
        String info = animal_db.trainAnimal(animalId, commandId);
        view.printAnswer(info);
    }

    public void getInfoPetCommandByAnimalID(int animal_id) {
        String info = animal_db.getInfoPetCommandByAnimalID(animal_id);
        view.printAnswer(info);
    }

    public boolean checkIsGroup(int group_id) {
        return animal_db.checkIsGroup(group_id);
    }

    public boolean checkIsType(int type_id) {
        return animal_db.checkIsType(type_id);
    }

    public boolean checkIsAnimal(int animal_id) {
        return animal_db.checkIsAnimal(animal_id);
    }

    public boolean checkIsCommand(int command_id) {
        return animal_db.checkIsCommand(command_id);
    }

    public boolean checkCommandIsEmpty() {
        return animal_db.checkCommandIsEmpty();
    }

    public void loadDB() {
    }


    public void getAnimalNameByID(int animalId) {
        String info = animal_db.getAnimalNameByID(animalId);
        view.printAnswer(info);
    }

    public void counter() {
        String info = animal_db.counter();
        view.printAnswer(info);
    }

    public void saver() throws IOException, ClassNotFoundException {
        String info;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/animalDB.mydb"))){
            oos.writeObject(animal_db);
            info = "База данных успешно сохранена в файл ";
        } catch (Exception e){
            info = "Что-то пошло не так, информация выше ";
        }
        view.printAnswer(info);
    }

    public void loader(){
        String info;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/animalDB.mydb"))){
            animal_db = (AnimalDB) ois.readObject();
            info = "База данных успешно загружена ";
        } catch (Exception e){
            info = "Что-то пошло не так, информация выше ";
        }
        view.printAnswer(info);
    }
}
