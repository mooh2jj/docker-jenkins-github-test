package com.example.gradlespringboottest.controller;

import com.example.gradlespringboottest.domain.Post;
import com.example.gradlespringboottest.repository.PostRepositroy;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private static final Integer PAGE_SIZE = 20;

    public final PostRepositroy postRepositroy;

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepositroy.save(post);
    }

/*    @GetMapping("/posts")
    public List<Post> getPostList() {
        return postRepositroy.findAll();
    }*/

    // 글 목록 페이징하여 반환
    @GetMapping("/posts")
    public Page<Post> getPostList(@RequestParam(defaultValue = "1") Integer page) {
        return postRepositroy.findAll(
                PageRequest.of(page - 1, PAGE_SIZE, Sort.by("id").descending())
        );
    }

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable("id") Long id) {
        return postRepositroy.findById(id).orElseThrow(
                () -> new RuntimeException("정상적으로 실행되지 못했습니다.")
        );
    }
}
