package com.alper.server.repositories;

import com.alper.server.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends MongoRepository<Post, String> {
}
