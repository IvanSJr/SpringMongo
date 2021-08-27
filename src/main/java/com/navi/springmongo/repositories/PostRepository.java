package com.navi.springmongo.repositories;

import com.navi.springmongo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTituloContainingIgnoreCase(String text);

    @Query("{ 'titulo': { $regex: ?0, $options: 'i'} }")
    List<Post> searchTitle(String text);

}
