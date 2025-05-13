
package com.example.mnj.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class CustMnjOntBomHeaderService {

    @PersistenceContext
    private EntityManager entityManager;

    private String userId;
    private String buyerName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @Transactional(readOnly = true)
    public void loadData() {
        Query query = entityManager.createQuery("SELECT b FROM Buyer b WHERE b.userId = :userId");
        query.setParameter("userId", userId);
        // Assuming Buyer is an entity class mapped to the database
        // Add logic to handle the result of the query
    }

    @Transactional
    public void saveBuyer() {
        // Logic to save buyer information
        // Assuming Buyer is an entity class mapped to the database
    }
}


### Application Properties (application.properties)
properties
spring.datasource.url=jdbc:your_database_url
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


### Controller Example

package com.example.mnj.controller;

import com.example.mnj.model.CustMnjOntBomHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buyer")
public class BuyerController {

    @Autowired
    private CustMnjOntBomHeaderService buyerService;

    @GetMapping("/{userId}")
    public String getBuyer(@PathVariable String userId) {
        buyerService.setUserId(userId);
        buyerService.loadData();
        return buyerService.getBuyerName(); // Return buyer name or other relevant data
    }

    @PostMapping
    public void createBuyer(@RequestBody String buyerName) {
        buyerService.setBuyerName(buyerName);
        buyerService.saveBuyer();
    }
}
