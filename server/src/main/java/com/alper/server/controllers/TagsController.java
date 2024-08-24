package com.alper.server.controllers;

import com.alper.server.entities.Tag;
import com.alper.server.models.CreateTagModel;
import com.alper.server.services.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagsController {
    private final ITagService _tagService;

    @Autowired
    public TagsController(ITagService tagService) {
        this._tagService = tagService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam String filter) {
        List<Tag> result = new ArrayList<>();
        try {
            result = _tagService.getAll(filter);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody CreateTagModel model) {
        try {
            _tagService.insert(model);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        return ResponseEntity.ok("Başarıyla eklendi");
    }
}
