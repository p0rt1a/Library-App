package com.alper.server.entities;

import lombok.Data;

@Data
public class Tag {
    private String name;

    public Tag(String name) {
        this.name = name;
    }
}
