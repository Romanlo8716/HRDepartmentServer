package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Controllers.WorkerController;
import com.example.hrdepartmentbase.Models.Post;
import com.example.hrdepartmentbase.Repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Iterable<Post> getAllPosts() {
        Iterable<Post> posts = new ArrayList<>();
        posts = postRepository.findAll();
        return  posts;
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);

        return post;
    }

    @Override
    public void createPosts(Post post) {
        postRepository.save(post);
        logger.info("All records saved.");
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteDepartmentsAndPostsOfWorkersByPost_Id(id);
        postRepository.deleteById(id);
    }

    @Override
    public void updatePost(Long id, Post post) {
        Post postUpdate = postRepository.findById(id).orElseThrow(() -> new ExpressionException("Post not exist with id: " + id));

        postUpdate.setNamePost(post.getNamePost());
        postUpdate.setSalary(post.getSalary());

        postRepository.save(postUpdate);
    }
}
