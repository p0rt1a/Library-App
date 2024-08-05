package com.alper.server.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tags")
public class Tag {
    @Id
    private String id;

    private String name;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }
}
