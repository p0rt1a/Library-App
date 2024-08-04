package com.alper.server.entities;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String username;
    private String password;
    private String email;
    private List<Book> favoriteBooks;
}
