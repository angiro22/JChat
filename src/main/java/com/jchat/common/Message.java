package com.jchat.common;

public class Message {
    String userMessage, username;

    public Message(String userMessage, String username) {
        this.userMessage = userMessage;
        this.username = username;
    }

    @Override
    public String toString() {
        return username + "::: " + userMessage;
    }
}
