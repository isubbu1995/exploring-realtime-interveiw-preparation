package multithreadingExp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer {
    private static final int PORT= 8080;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
        while (true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getInetAddress());
            // Create a new thread for each client connection
            new Thread(new ClientHandler(clientSocket)).start();
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
