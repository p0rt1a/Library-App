package com.alper.server.repositories;

import com.alper.server.entities.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends MongoRepository<Tag, String> {
}
