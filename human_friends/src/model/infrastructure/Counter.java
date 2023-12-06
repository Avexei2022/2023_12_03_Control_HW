package model.infrastructure;

public class Counter {
    private int pets_count;

    public Counter(){
        pets_count = 0;
    }

    public int getPetsCount(){
        return pets_count;
    }

    public void increment(){
        pets_count++;
    }
}
