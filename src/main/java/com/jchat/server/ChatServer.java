package com.jchat.server;

import com.jchat.common.Protocol;

import java.net.*;
import java.io.*;

public class ChatServer {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(Protocol.PORT);
            System.out.println("Waiting for connection...");
            while (true) {
                clientSocket = serverSocket.accept();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

        try {
            clientSocket.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}