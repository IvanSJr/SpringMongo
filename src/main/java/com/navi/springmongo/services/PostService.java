package com.navi.springmongo.services;

import com.navi.springmongo.dto.UserDTO;
import com.navi.springmongo.entities.Post;
import com.navi.springmongo.entities.User;
import com.navi.springmongo.repositories.PostRepository;
import com.navi.springmongo.repositories.UserRepository;
import com.navi.springmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
