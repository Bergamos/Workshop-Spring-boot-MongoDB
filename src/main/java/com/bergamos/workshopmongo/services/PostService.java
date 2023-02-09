package com.bergamos.workshopmongo.services;

import com.bergamos.workshopmongo.entities.Post;
import com.bergamos.workshopmongo.repositories.PostRepository;
import com.bergamos.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Id is not existing."));
    }
}
