package com.example.gradlespringboottest.rabbitmq;

import com.example.gradlespringboottest.domain.Post;
import com.example.gradlespringboottest.repository.PostRepositroy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {

    private final ObjectMapper objectMapper;

    private final PostRepositroy postRepositroy;

    @RabbitListener(queues = "CREATE_POST_QUEUE")
    public void handler(String message) throws JsonProcessingException {
        Post post = objectMapper.readValue(message, Post.class);
        // 메시지 내용 큐에 들어감.
        postRepositroy.save(post);
    }
}
