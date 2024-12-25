package multithreadingExp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
    this.clientSocket= clientSocket;
    }

    @Override
    public void run() {
    try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); OutputStream outputStream = clientSocket.getOutputStream()){
        String requestLine; while ((requestLine = in.readLine()) != null && !requestLine.isEmpty()) {
            System.out.println("Received request: " + requestLine);
        }
        // Send a simple HTTP response
        String httpResponse = "HTTP/1.1 200 OK\r\n\r\nHello, World!";
        outputStream.write(httpResponse.getBytes());
        clientSocket.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
}
