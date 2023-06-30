package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestParam("userId") Long userId, @RequestParam("content") String content) {
        Post post = postService.createPost(userId, content);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping(value = "/user/tweet")
    public String displaytweet(Model model) {
        List<Post> tweet = postService.getAllPosts();
        model.addAttribute("tweetList", tweet);
        return "user/tweet";
    }
}

