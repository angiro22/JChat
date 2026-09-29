package com.jchat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class ClientHandler extends Thread {
    Socket clientSocket;
    ChatServer server;

    public ClientHandler(Socket clientSocket, ChatServer server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outputStream = new PrintWriter(clientSocket.getOutputStream());

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
