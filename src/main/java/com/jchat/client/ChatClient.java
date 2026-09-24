package com.jchat.client;

import java.net.*;
import java.io.*;

public class ChatClient {
    static void main(String[] args) {
        Socket clientSocket = null;
        String host = "127.0.0.1";
        int port = 3333;

        try {
            clientSocket = new Socket(host, port);
            System.out.println("Connected.");
        } catch (IOException e) {
            System.err.println(e);
        }

        try {
            // Input stream from socket
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // Output stream on socket
            PrintWriter outputStream = new PrintWriter(clientSocket.getOutputStream());
            // Keyboard user input
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("=== JChat started ===");

            while (true) {
                // Message to send
                String outMessage = userInput.readLine();
                if (outMessage.equals("/exit"))
                    break;

                outputStream.println(userInput);
                outputStream.flush();

                // Message to receive
                String inMessage = inputStream.readLine();
                System.out.println(inMessage);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
