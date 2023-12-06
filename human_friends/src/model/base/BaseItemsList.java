package model.base;

import java.io.Serializable;

public interface BaseItemsList extends Serializable {
    int getId();
    String getName();
    void setId(int id);

}
