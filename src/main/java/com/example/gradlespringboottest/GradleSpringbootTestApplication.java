package com.example.gradlespringboottest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
@SpringBootApplication
@AllArgsConstructor
public class GradleSpringbootTestApplication implements ApplicationListener<ApplicationStartedEvent> {

    public static void main(String[] args) {
        SpringApplication.run(GradleSpringbootTestApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        log.debug("docker-jenkins-github-test START!!");
    }
}
