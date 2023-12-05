package model.base;

import java.io.Serializable;
import java.util.Objects;

public abstract class Base implements BaseItemsList, Serializable {
    private int id;
    private String name;
    public Base(String name){
        id = -1;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  boolean equals(Object obj){
        if (this == obj){
            return  true;
        }
        if (!(obj instanceof Base base)){
            return false;
        }
        return Objects.equals(base.getName(), getName());
    }
}
