package com.alper.server.services.impl;

import com.alper.server.entities.Tag;
import com.alper.server.models.CreateTagModel;
import com.alper.server.repositories.ITagRepository;
import com.alper.server.services.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements ITagService {
    private final ITagRepository _tagRepository;

    @Autowired
    public TagServiceImpl(ITagRepository tagRepository) {
        this._tagRepository = tagRepository;
    }

    @Override
    public void insert(CreateTagModel model) throws Exception {
        Tag tag = Tag.builder().name(model.getName()).build();

        _tagRepository.save(tag);
    }

    @Override
    public List<Tag> getAll(String filter) {
        return _tagRepository.findByNameContaining(filter);
    }
}
