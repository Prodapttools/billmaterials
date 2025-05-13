
package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class PopulateService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object> executeQueryForCollection(String queryString, Object... params) {
        Query query = entityManager.createQuery(queryString);
        setParameters(query, params);
        return query.getResultList();
    }

    public boolean hasNextForCollection(String queryString, Object... params) {
        List<Object> results = executeQueryForCollection(queryString, params);
        return !results.isEmpty();
    }

    public long getQueryHitCount(String queryString, Object... params) {
        Query query = entityManager.createQuery("SELECT COUNT(o) FROM (" + queryString + ") o");
        setParameters(query, params);
        return (long) query.getSingleResult();
    }

    private void setParameters(Query query, Object... params) {
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
    }
}


### Application Properties Configuration (application.properties)
properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


### Controller Example

package com.example.demo.controller;

import com.example.demo.model.PopulateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/populate")
public class PopulateController {

    @Autowired
    private PopulateService populateService;

    @GetMapping("/query")
    public List<Object> executeQuery(@RequestParam String queryString, @RequestParam Object... params) {
        log.info("Executing query: {}", queryString);
        return populateService.executeQueryForCollection(queryString, params);
    }

    @GetMapping("/hasNext")
    public boolean hasNext(@RequestParam String queryString, @RequestParam Object... params) {
        return populateService.hasNextForCollection(queryString, params);
    }

    @GetMapping("/count")
    public long getQueryHitCount(@RequestParam String queryString, @RequestParam Object... params) {
        return populateService.getQueryHitCount(queryString, params);
    }
}
