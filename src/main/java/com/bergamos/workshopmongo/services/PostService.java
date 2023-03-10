package com.bergamos.workshopmongo.services;

import com.bergamos.workshopmongo.entities.Post;
import com.bergamos.workshopmongo.repositories.PostRepository;
import com.bergamos.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Id is not existing."));
    }

    public List<Post> findByTitle(String text) {
        return  postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
        return postRepository.fullSearch(text, minDate, maxDate);

    }

}
