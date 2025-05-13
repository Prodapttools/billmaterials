
package com.example.demo.model;

import org.springframework.stereotype.Component;

// ---------------------------------------------------------------------
// ---    Converted from Oracle ADF Business Components to Spring Boot.
// ---------------------------------------------------------------------
@Component
public class BomBpoLinesAll {

    /**
     * This is the default constructor (do not remove).
     */
    public BomBpoLinesAll() {
    }

    // Add any necessary methods or properties here
}



package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.BomBpoLinesAll;

@Repository
public interface BomBpoLinesAllRepository extends JpaRepository<BomBpoLinesAll, Long> {
    // Define custom query methods if needed
}



package com.example.demo.service;

import com.example.demo.model.BomBpoLinesAll;
import com.example.demo.repository.BomBpoLinesAllRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BomBpoLinesAllService {

    private final BomBpoLinesAllRepository repository;

    @Autowired
    public BomBpoLinesAllService(BomBpoLinesAllRepository repository) {
        this.repository = repository;
    }

    public List<BomBpoLinesAll> findAll() {
        return repository.findAll();
    }

    // Add other service methods as needed
}



package com.example.demo.controller;

import com.example.demo.model.BomBpoLinesAll;
import com.example.demo.service.BomBpoLinesAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bom-bpo-lines")
public class BomBpoLinesAllController {

    private final BomBpoLinesAllService service;

    @Autowired
    public BomBpoLinesAllController(BomBpoLinesAllService service) {
        this.service = service;
    }

    @GetMapping
    public List<BomBpoLinesAll> getAllBomBpoLines() {
        return service.findAll();
    }

    // Add other endpoints as needed
}


yaml
# application.yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database
    username: your_username
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
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
