
package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
@Table(name = "bom_obline_details")
@EntityListeners(AuditingEntityListener.class)
public class BomOblineDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add other fields as per your database schema

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Add other getters and setters
}



package com.example.demo.repository;

import com.example.demo.model.BomOblineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BomOblineDetailsRepository extends JpaRepository<BomOblineDetails, Long> {
    // Custom query methods can be defined here
}



package com.example.demo.service;

import com.example.demo.model.BomOblineDetails;
import com.example.demo.repository.BomOblineDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BomOblineDetailsService {

    private final BomOblineDetailsRepository repository;

    @Autowired
    public BomOblineDetailsService(BomOblineDetailsRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public BomOblineDetails insertBomOblineDetails(BomOblineDetails details) {
        return repository.save(details);
    }

    public List<BomOblineDetails> getAllBomOblineDetails() {
        return repository.findAll();
    }
}



package com.example.demo.controller;

import com.example.demo.model.BomOblineDetails;
import com.example.demo.service.BomOblineDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bom-obline-details")
public class BomOblineDetailsController {

    private final BomOblineDetailsService service;

    @Autowired
    public BomOblineDetailsController(BomOblineDetailsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BomOblineDetails> createBomOblineDetails(@RequestBody BomOblineDetails details) {
        BomOblineDetails createdDetails = service.insertBomOblineDetails(details);
        return ResponseEntity.ok(createdDetails);
    }

    @GetMapping
    public ResponseEntity<List<BomOblineDetails>> getAllBomOblineDetails() {
        List<BomOblineDetails> detailsList = service.getAllBomOblineDetails();
        return ResponseEntity.ok(detailsList);
    }
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
