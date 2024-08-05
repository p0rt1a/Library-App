package com.alper.server.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "posts")
public class Post {
    @Id
    private String id;

    private User user;
    //TODO think about list of images?
    private String image;
    private Date createdAt = new Date();
    private List<Tag> tags;
}
