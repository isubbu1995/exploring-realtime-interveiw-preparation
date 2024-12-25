package volatilekeyword;

public class Worker  implements Runnable{
    private final Server server;

    public Worker(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        while (server.isRunning()) {
            // Simulate doing some work
             System.out.println("Worker is processing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Worker has stopped.");
    }
}
