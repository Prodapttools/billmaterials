
package com.example.demo.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustMnjOntBomOblineDetailsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertRow(CustMnjOntBomOblineDetails row) {
        List<CustMnjOntBomOblineDetails> rows = findAll();
        if (!rows.isEmpty()) {
            // Insert new row at the end
            entityManager.persist(row);
        } else {
            // Handle empty rowset case if needed
            entityManager.persist(row);
        }
    }

    public List<CustMnjOntBomOblineDetails> findAll() {
        TypedQuery<CustMnjOntBomOblineDetails> query = entityManager.createQuery("SELECT c FROM CustMnjOntBomOblineDetails c", CustMnjOntBomOblineDetails.class);
        return query.getResultList();
    }
}



package com.example.demo.controller;

import com.example.demo.model.CustMnjOntBomOblineDetails;
import com.example.demo.model.CustMnjOntBomOblineDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bom-details")
public class CustMnjOntBomOblineDetailsController {

    private final CustMnjOntBomOblineDetailsRepository repository;

    @Autowired
    public CustMnjOntBomOblineDetailsController(CustMnjOntBomOblineDetailsRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void insertRow(@RequestBody CustMnjOntBomOblineDetails row) {
        repository.insertRow(row);
    }

    @GetMapping
    public List<CustMnjOntBomOblineDetails> getAllRows() {
        return repository.findAll();
    }
}



package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustMnjOntBomOblineDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add other fields and their getters/setters here

    // Getters and Setters
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
