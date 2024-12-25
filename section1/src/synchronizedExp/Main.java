package multithreadingExp.synchronizedExp;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(new Worker(counter));
        Thread thread2 = new Thread(new Worker(counter));
        Thread thread3 = new Thread(new Worker(counter));
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Final count: " + counter.getCounter());
    }
}

