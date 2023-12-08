package model.counter;

public class Counter implements AutoCloseable {
    private static volatile Counter counter;
    private static int pets_count;

    private Counter() {
        pets_count = 0;
    }

    public static Counter getCounter() {
        if (counter == null) {
            synchronized (Counter.class) {
                if (counter == null) {
                    counter = new Counter();
                }
            }
        }
        return counter;
    }

    public int getPetsCount(){
        return pets_count;
    }

    public void setPetsCount(int count){
        pets_count = count;
    }

    public void add(){
        pets_count++;
    }

    @Override
    public void close() throws Exception {

    }
}
