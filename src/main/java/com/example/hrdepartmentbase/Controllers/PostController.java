package com.example.hrdepartmentbase.Controllers;


import com.example.hrdepartmentbase.Models.Post;
import com.example.hrdepartmentbase.Models.Worker;
import com.example.hrdepartmentbase.Repository.PostRepository;
import com.example.hrdepartmentbase.Repository.WorkerRepository;
import com.example.hrdepartmentbase.Services.PostService;
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
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class PostController {

    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "getPosts")
    public Iterable<Post> getAllPosts(){

        return  postService.getAllPosts();
    }

    @GetMapping(value = "getPostById/{id}")
    public Optional<Post> getPostById(@PathVariable("id") Long id){


        return postService.getPostById(id);
    }

    @PostMapping(value = "createPosts")
    public void createPosts(@RequestBody Post post){
        postService.createPosts(post);
    }

    @DeleteMapping(value = "deletePost/{id}")
    public void deletePost(@PathVariable ("id") Long id){
       postService.deletePost(id);
    }

    @PutMapping(value = "updatePost/{id}")
    public void updatePost(@PathVariable ("id") Long id, @RequestBody Post post){
     postService.updatePost(id, post);

    }
}
