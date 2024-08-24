package com.alper.server.services;

import com.alper.server.entities.Tag;
import com.alper.server.models.CreateTagModel;

import java.util.List;

public interface ITagService {
    void insert(CreateTagModel model) throws Exception;
    List<Tag> getAll(String filter);
}
