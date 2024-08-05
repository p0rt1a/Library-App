package com.alper.server.models;

import lombok.Data;

@Data
public class CreateTagModel {
    private String name;

    public CreateTagModel(String name) {
        this.name = name;
    }
}
