package com.navi.springmongo.repositories;

import com.navi.springmongo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTituloContainingIgnoreCase(String text);

}
