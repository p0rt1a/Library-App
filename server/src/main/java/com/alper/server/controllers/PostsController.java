package com.alper.server.controllers;

import com.alper.server.entities.Post;
import com.alper.server.models.CreatePostModel;
import com.alper.server.services.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {
    private final PostServiceImpl _postService;

    @Autowired
    public PostsController(PostServiceImpl postService) {
        this._postService = postService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Post> postList = new ArrayList<>();

        try {
            postList = _postService.getAll();
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        return ResponseEntity.ok(postList);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody CreatePostModel model) {
        try {
            _postService.insert(model);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        return ResponseEntity.ok().build();
    }
}
