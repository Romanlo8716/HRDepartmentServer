package com.example.hrdepartmentbase.Controllers;


import com.example.hrdepartmentbase.Models.Post;
import com.example.hrdepartmentbase.Models.Worker;
import com.example.hrdepartmentbase.Repository.PostRepository;
import com.example.hrdepartmentbase.Repository.WorkerRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionException;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PostController {

    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping(value = "getPosts")
    public Iterable<Post> getAllPosts(){

        Iterable<Post> posts = new ArrayList<>();
        posts = postRepository.findAll();
        return  posts;
    }

    @PostMapping(value = "createPosts")
    public void createPosts(@RequestBody Post post){

        postRepository.save(post);
        logger.info("All records saved.");
    }

    @DeleteMapping(value = "deletePost/{id}")
    public void deletePost(@PathVariable ("id") Long id){
        postRepository.deleteById(id);
    }

    @PutMapping(value = "updatePost/{id}")
    public Post updatePost(@PathVariable ("id") Long id, @RequestBody Post post){
        Post postUpdate = postRepository.findById(id).orElseThrow(() -> new ExpressionException("Post not exist with id: " + id));

        postUpdate.setNamePost(post.getNamePost());

        return postRepository.save(post);
    }
}
