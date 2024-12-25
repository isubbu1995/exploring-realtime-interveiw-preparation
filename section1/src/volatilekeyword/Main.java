package volatilekeyword;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        Worker worker = new Worker(server);

        Thread workerThread = new Thread(worker);

        server.start();
        workerThread.start();

        // Let the server run for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        server.stop();

        // Wait for the worker thread to finish
        try {
            workerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Server has shut down.");
    }
}
