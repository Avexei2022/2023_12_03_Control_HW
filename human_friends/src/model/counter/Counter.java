package model.counter;

import java.io.Serial;
import java.io.Serializable;

public class Counter implements Serializable, AutoCloseable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static int pets_count;

    public Counter(){
        pets_count = 0;
    }

    public int getPetsCount(){
        return pets_count;
    }

    public void add(){
        pets_count++;
    }

    @Override
    public void close() throws Exception {

    }
}
