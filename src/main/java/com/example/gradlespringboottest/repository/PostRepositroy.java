package com.example.gradlespringboottest.repository;

import com.example.gradlespringboottest.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepositroy extends JpaRepository<Post, Long> {
    List<Post> findByContentContains(String content);
}

