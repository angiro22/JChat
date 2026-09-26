package com.jchat.common;

public class Message {
    String userMessage, username;

    public Message(String userMessage, String username) {
        this.userMessage = userMessage;
        this.username = username;
    }

    @Override
    public String toString() {
        return username + Protocol.SEPARATOR + " " + userMessage;
    }

    // Given a message, this method parse it to a Message object
    public static Message StringToMessage(String messageReceived) {
        String username, text;
        username = messageReceived.substring(0, messageReceived.indexOf(Protocol.SEPARATOR));
        // Use separator + 2 for the text index because in toString() the text is sent with a space after the separator
        text = messageReceived.substring(messageReceived.indexOf(Protocol.SEPARATOR) + 2);

        return new Message(text, username); 
    }
}
