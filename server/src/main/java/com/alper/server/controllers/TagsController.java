package com.alper.server.controllers;

import com.alper.server.entities.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagsController {
    List<Tag> tagsList = Arrays.asList(new Tag("aksiyon"), new Tag("macera"), new Tag("bilim-kurgu"));

    @GetMapping
    public List<Tag> getAll() {

        return tagsList;
    }

    @PostMapping
    public void insert(@RequestBody Tag model) {
        tagsList.add(model);
    }
}
