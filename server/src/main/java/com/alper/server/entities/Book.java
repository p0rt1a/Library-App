package com.alper.server.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "books")
public class Book {
    @Id
    private String id;

    private String name;
    private String author;
    private String description;
    private int pageCount;
    private Date publishedAt;
}
