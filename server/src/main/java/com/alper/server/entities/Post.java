package com.alper.server.entities;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Post {
    private User user;
    //TODO think about list of images?
    private String image;
    private Date createdAt = new Date();
    private List<Tag> tags;
}
