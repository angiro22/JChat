import java.net.*;
import java.io.*;

public class ChatServer {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket clientSocket = null;
        int port = 3333;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for connection...");
            while (true) {
                clientSocket = serverSocket.accept();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}