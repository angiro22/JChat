package com.jchat.server;

import com.jchat.common.Protocol;

import java.net.*;
import java.io.*;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatServer {
    private final Set<ClientHandler> handlers = new CopyOnWriteArraySet<>();

    void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(Protocol.PORT)) {
            System.out.println("Waiting for connection...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                handlers.add(clientHandler);
                clientHandler.start();
            }
        }
    }

    // =================================
    // Add broadcast and deleting method
    // =================================

    static void main(String[] args) {
        try {
            new ChatServer().start();
        } catch (BindException e) {
            System.err.println(Protocol.PORT + " port busy: " + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            System.exit(1);
        }
    }
}