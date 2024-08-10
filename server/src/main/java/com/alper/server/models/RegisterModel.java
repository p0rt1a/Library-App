package com.alper.server.models;

import lombok.Data;

@Data
public class RegisterModel {
    private String username;
    private String password;
    private String email;
}
