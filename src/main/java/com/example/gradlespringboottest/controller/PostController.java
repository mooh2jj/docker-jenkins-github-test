package com.example.gradlespringboottest.controller;

import com.example.gradlespringboottest.domain.Post;
import com.example.gradlespringboottest.repository.PostRepositroy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    public final PostRepositroy postRepositroy;

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepositroy.save(post);
    }

    @GetMapping("/posts")
    public List<Post> getPostList() {
        return postRepositroy.findAll();
    }
}
