package com.example.gradlespringboottest.repository;

import com.example.gradlespringboottest.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepositroy extends JpaRepository<Post, Long> {
}
