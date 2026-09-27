package com.jchat.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void givenMessage_whenParsedToString_thenReturnsExpectedString() {
        Message m = new Message("username", "hello world!");
        assertEquals("username; hello world!", m.toString());
    }

    @Test
    void givenString_whenParsedToMessage_thenReturnsExpectedMessage() {
        Message m = Message.toMessage("username; hello world!");
        assertEquals("username", m.username);
        assertEquals("hello world!", m.text);
    }

    @Test
    void givenMessage_whenReconstructed_thenReturnsInitialMessage() {
        Message original = new Message("username", "hello world!");
        Message reconstructed = Message.toMessage(original.toString());
        assertEquals(reconstructed.username, original.username);
        assertEquals(reconstructed.text, original.text);
    }

    @Test
    void givenMessage_whenTextWithSeparator_thenReturnsExpectedText() {
        Message m = new Message("username", "hello;world!");
        assertEquals("hello;world!", m.text);
    }
}
