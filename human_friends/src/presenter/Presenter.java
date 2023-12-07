package presenter;

import model.HumanFriendsDB;
import model.exception_app.MyClassNotFoundException;
import model.exception_app.MyFileNotFoundException;
import model.exception_app.MyIOException;
import view.View;

import java.io.*;
import java.time.LocalDate;

public class Presenter {
    private final View view;
    private HumanFriendsDB humanFriendsDB;

    public Presenter(View view) {
        this.view = view;
        this.humanFriendsDB = new HumanFriendsDB();
    }

    public void printAnimalList(int id1_bd2) {
        String info = humanFriendsDB.printAnimalList(id1_bd2);
        view.printAnswer(info);
    }

    public void printGroupList() {
        String info = humanFriendsDB.printGroupList();
        view.printAnswer(info);
    }
    public void printTypeList() {
        String info = humanFriendsDB.printTypeList();
        view.printAnswer(info);
    }

    public void printCommandList() {
        String info = humanFriendsDB.printCommandList();
        view.printAnswer(info);
    }

    public void addGroup(String name) {
        String info = humanFriendsDB.addGroup(name);
        view.printAnswer(info);
    }

    public void addType(int groupId, String name) {
        String info = humanFriendsDB.addType(groupId, name);
        view.printAnswer(info);
    }

    public void addAnimal(int groupId, String name, LocalDate birthday) {
        String info = humanFriendsDB.addAnimal(groupId, name, birthday);
        view.printAnswer(info);
    }
    public void addCommand(String name) {
        String info = humanFriendsDB.addCommand(name);
        view.printAnswer(info);
    }

    public void trainAnimal(int animalId, int commandId) {
        String info = humanFriendsDB.trainAnimal(animalId, commandId);
        view.printAnswer(info);
    }

    public void getInfoPetCommandByAnimalID(int animal_id) {
        String info = humanFriendsDB.getInfoPetCommandByAnimalID(animal_id);
        view.printAnswer(info);
    }

    public boolean checkIsGroup(int group_id) {
        return humanFriendsDB.checkIsGroup(group_id);
    }

    public boolean checkIsType(int type_id) {
        return humanFriendsDB.checkIsType(type_id);
    }

    public boolean checkIsAnimal(int animal_id) {
        return humanFriendsDB.checkIsAnimal(animal_id);
    }

    public boolean checkIsCommand(int command_id) {
        return humanFriendsDB.checkIsCommand(command_id);
    }

    public boolean checkCommandIsEmpty() {
        return humanFriendsDB.checkCommandIsEmpty();
    }

    public void getAnimalNameByID(int animalId) {
        String info = humanFriendsDB.getAnimalNameByID(animalId);
        view.printAnswer(info);
    }

    public void counter() {
        String info = humanFriendsDB.counter();
        view.printAnswer(info);
    }

    public void saveDB(String file_name) {
        String info;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file_name))){
            oos.writeObject(humanFriendsDB);
            info = "База данных успешно сохранена в файл " + file_name;
        } catch (FileNotFoundException e){
            info = "Что-то пошло не так.";
            throw new MyFileNotFoundException(file_name, e.fillInStackTrace().toString());
        } catch (IOException e){
            throw new MyIOException(file_name, e.fillInStackTrace().toString());
        }
        view.printAnswer(info);
    }

    public void loadDB(String file_name){
        String info;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_name))){
            humanFriendsDB = (HumanFriendsDB) ois.readObject();
            info = "База данных успешно загружена ";
        } catch (FileNotFoundException e){
            info = "Что-то пошло не так.";
            throw new MyFileNotFoundException(file_name, e.fillInStackTrace().toString());
        } catch (IOException e){
            throw new MyIOException(file_name, e.fillInStackTrace().toString());
        } catch (ClassNotFoundException e) {
            throw new MyClassNotFoundException(file_name, e.fillInStackTrace().toString());
        }
        view.printAnswer(info);
    }
}
