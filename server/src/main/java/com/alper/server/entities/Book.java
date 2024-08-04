package com.alper.server.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private String name;
    private String author;
    private String description;
    private int pageCount;
    private Date publishedAt;
}
