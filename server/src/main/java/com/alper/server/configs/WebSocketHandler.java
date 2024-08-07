package com.alper.server.configs;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println("Received message: " + message.getPayload());
        try {
            // Echo the message back to the client
            session.sendMessage(new TextMessage("Server received: " + message.getPayload()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

