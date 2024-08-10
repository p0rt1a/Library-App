package com.alper.server.services.impl;

import com.alper.server.entities.Post;
import com.alper.server.entities.User;
import com.alper.server.models.CreatePostModel;
import com.alper.server.repositories.IPostRepository;
import com.alper.server.repositories.IUserRepository;
import com.alper.server.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {
    private final IPostRepository _postRepository;
    private final IUserRepository _userRepository;

    @Autowired
    public PostServiceImpl(IPostRepository postRepository, IUserRepository userRepository) {
        this._postRepository = postRepository;
        this._userRepository = userRepository;
    }

    //TODO use filtered instead:
    @Override
    public List<Post> getAll() {
        return _postRepository.findAll();
    }

    @Override
    public void insert(CreatePostModel model) {
        User user = _userRepository.findById(model.getUserID()).orElseThrow();
        Post post = Post.builder().image(model.getImage()).tags(model.getTags()).user(user).build();

        _postRepository.save(post);
    }
}
