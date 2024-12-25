package multithreadingExp.synchronizedExp;

public class Counter {
    private int counter;
    public synchronized void increment(){
        counter++;
    }
    public synchronized int getCounter(){
        return counter;
    }
}
