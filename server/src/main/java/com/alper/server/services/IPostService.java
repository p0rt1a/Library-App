package com.alper.server.services;

import com.alper.server.entities.Post;
import com.alper.server.models.CreatePostModel;

import java.util.List;

public interface IPostService {
    public List<Post> getAll();
    public void insert(CreatePostModel post);
}
