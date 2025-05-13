
package com.example.demo.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustMnjOntBomRmlineLinesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertRow(CustMnjOntBomRmlineLines row) {
        if (getLastRow() != null) {
            entityManager.persist(row);
        } else {
            entityManager.persist(row);
        }
    }

    public CustMnjOntBomRmlineLines getLastRow() {
        TypedQuery<CustMnjOntBomRmlineLines> query = entityManager.createQuery("SELECT c FROM CustMnjOntBomRmlineLines c ORDER BY c.id DESC", CustMnjOntBomRmlineLines.class);
        List<CustMnjOntBomRmlineLines> results = query.setMaxResults(1).getResultList();
        return results.isEmpty() ? null : results.get(0);
    }
}



package com.example.demo.controller;

import com.example.demo.model.CustMnjOntBomRmlineLines;
import com.example.demo.model.CustMnjOntBomRmlineLinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rmline-lines")
public class CustMnjOntBomRmlineLinesController {

    private final CustMnjOntBomRmlineLinesRepository repository;

    @Autowired
    public CustMnjOntBomRmlineLinesController(CustMnjOntBomRmlineLinesRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void insertRow(@RequestBody CustMnjOntBomRmlineLines row) {
        repository.insertRow(row);
    }
}



package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustMnjOntBomRmlineLines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields, getters, and setters
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
