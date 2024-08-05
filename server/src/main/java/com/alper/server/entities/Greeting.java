package com.alper.server.entities;

import lombok.Data;

@Data
public class Greeting {
    private String message;

    public Greeting(String message) {
        this.message = message;
    }
}
