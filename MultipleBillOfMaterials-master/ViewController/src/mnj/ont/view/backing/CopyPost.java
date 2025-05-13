
package com.example.demo.controller;

import com.example.demo.service.CopyPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/copy-post")
@RequiredArgsConstructor
@Slf4j
public class CopyPostController {

    private final CopyPostService copyPostService;

    @PostMapping("/copy")
    public void copy() {
        log.info("Executing copy operation");
        copyPostService.executeCopy();
    }

    @PostMapping("/post")
    public void post() {
        log.info("Executing post operation");
        copyPostService.executePost();
    }
}



package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CopyPostService {

    @Transactional
    public void executeCopy() {
        // Add logic for copy operation
        // Example: call repository or perform business logic
    }

    @Transactional
    public void executePost() {
        // Add logic for post operation
        // Example: call repository or perform business logic
    }
}



package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopyPostRepository extends JpaRepository<YourEntity, Long> {
    // Define custom query methods if needed
}


yaml
# application.yml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/mydb
    username: myuser
    password: mypassword
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true



package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
