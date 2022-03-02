package com.example.gradlespringboottest.controller;

import com.example.gradlespringboottest.domain.Post;
import com.example.gradlespringboottest.rabbitmq.Producer;
import com.example.gradlespringboottest.repository.PostRepositroy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private final PostRepositroy postRepositroy;
    private final Producer producer;
    private final ObjectMapper objectMapper;

    @PostMapping
    public Post createPost(@RequestBody Post post) throws JsonProcessingException {
        String jsonPost = objectMapper.writeValueAsString(post);
        producer.sendTo(jsonPost);
        return post;
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

    // 글 내용으로 검색 -> 해당 내용 포함한 모든 글
    @GetMapping("/search")
    public List<Post> findPostsByContent(@RequestParam String content) {
        return postRepositroy.findByContentContains(content);
    }
}
