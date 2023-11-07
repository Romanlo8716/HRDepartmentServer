package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.Post;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface PostService {

    Iterable<Post> getAllPosts();

    Optional<Post> getPostById(@PathVariable("id") Long id);

    void createPosts(@RequestBody Post post);

    void deletePost(@PathVariable ("id") Long id);

    void updatePost(@PathVariable ("id") Long id, @RequestBody Post post);




}
