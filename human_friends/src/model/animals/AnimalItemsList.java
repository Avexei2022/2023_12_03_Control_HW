package model.animals;

import model.commands.AnimalCommand;

import java.time.LocalDate;
import java.util.List;

public interface AnimalItemsList {
    LocalDate getBirthday();
    void setBirthday(LocalDate birthday);
}
