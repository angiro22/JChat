package com.jchat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class ClientHandler extends Thread {
    private final Socket clientSocket;
    private final ChatServer server;
    private final PrintWriter outputStream;

    public ClientHandler(Socket clientSocket, ChatServer server) throws IOException {
        this.clientSocket = clientSocket;
        this.server = server;

        outputStream = new PrintWriter(clientSocket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String username = inputStream.readLine();

            while (true) {
                String message = inputStream.readLine();
                if (message == null)
                    break;
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
