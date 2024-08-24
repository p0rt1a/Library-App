package com.alper.server.models;

import com.alper.server.entities.Tag;
import lombok.Data;

import java.util.List;

@Data
public class CreatePostModel {
    private String userID;
    private String image;
    private String description;
    private List<Tag> tags;
}
