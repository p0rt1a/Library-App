package com.alper.server.repositories;

import com.alper.server.entities.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITagRepository extends MongoRepository<Tag, String> {
    List<Tag> findByNameContaining(String filter);
}
