package com.jchat.client;

import com.jchat.common.Protocol;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatClient {
    static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        String username = keyboardInput.nextLine();
        keyboardInput.nextLine();

        Socket clientSocket = null;

        try {
            clientSocket = new Socket(Protocol.HOST, Protocol.PORT);
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
                if (outMessage.equals(Protocol.EXIT_COMMAND))
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
