package com.alper.server.controllers;

import com.alper.server.entities.Tag;
import com.alper.server.repositories.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagsController {
    @Autowired
    ITagRepository _tagRepository;
    @Autowired
    MongoTemplate _mongoTemplate;

    public TagsController(ITagRepository tagRepository, MongoTemplate mongoTemplate) {
        this._tagRepository = tagRepository;
        this._mongoTemplate = mongoTemplate;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Tag> result = new ArrayList<>();
        try {
            result = _tagRepository.findAll();
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Tag model) {
        try {
            _tagRepository.save(model);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        return ResponseEntity.ok("Başarıyla eklendi");
    }
}
