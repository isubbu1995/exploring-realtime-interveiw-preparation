package volatilekeyword;

public class Server {
    private volatile boolean running = false;

    public void start() {
        running = true;
        System.out.println("Server started.");
    }

    public void stop() {
        running = false;
        System.out.println("Server stopped.");
    }

    public boolean isRunning() {
        return running;
    }
}
