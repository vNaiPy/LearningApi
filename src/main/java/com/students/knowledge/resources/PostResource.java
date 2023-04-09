package com.students.knowledge.resources;

import com.students.knowledge.domain.Post;
import com.students.knowledge.resources.util.URL;
import com.students.knowledge.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService _postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById (@PathVariable String id) {
        Post post = _postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle (@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> postList = _postService.findByTitle(text);
        return ResponseEntity.ok().body(postList);
    }
}
