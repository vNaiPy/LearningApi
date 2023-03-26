package com.students.knowledge.services;

import com.students.knowledge.domain.Post;
import com.students.knowledge.repositories.PostRepository;
import com.students.knowledge.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository _postRepository;

    public Post findById (String id) {
        Optional<Post> optionalPost = _postRepository.findById(id);
        if (optionalPost.isEmpty()) throw new ObjectNotFoundException("Postagem não encontrada");
        return optionalPost.get();
    }
}
