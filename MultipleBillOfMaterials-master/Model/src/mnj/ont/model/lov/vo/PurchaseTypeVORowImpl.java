
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_type")
public class PurchaseType {

    @Id
    private Long id; // Assuming there's an ID field

    // Add other fields as necessary

    // Default constructor
    public PurchaseType() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Add other getters and setters as necessary
}



package com.example.demo.repository;

import com.example.demo.model.PurchaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseTypeRepository extends JpaRepository<PurchaseType, Long> {
    // Custom query methods can be defined here
}



package com.example.demo.service;

import com.example.demo.model.PurchaseType;
import com.example.demo.repository.PurchaseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseTypeService {

    private final PurchaseTypeRepository purchaseTypeRepository;

    @Autowired
    public PurchaseTypeService(PurchaseTypeRepository purchaseTypeRepository) {
        this.purchaseTypeRepository = purchaseTypeRepository;
    }

    @Transactional(readOnly = true)
    public List<PurchaseType> findAll() {
        return purchaseTypeRepository.findAll();
    }

    @Transactional
    public PurchaseType save(PurchaseType purchaseType) {
        return purchaseTypeRepository.save(purchaseType);
    }

    // Add other service methods as necessary
}



package com.example.demo.controller;

import com.example.demo.model.PurchaseType;
import com.example.demo.service.PurchaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-types")
public class PurchaseTypeController {

    private final PurchaseTypeService purchaseTypeService;

    @Autowired
    public PurchaseTypeController(PurchaseTypeService purchaseTypeService) {
        this.purchaseTypeService = purchaseTypeService;
    }

    @GetMapping
    public ResponseEntity<List<PurchaseType>> getAllPurchaseTypes() {
        List<PurchaseType> purchaseTypes = purchaseTypeService.findAll();
        return ResponseEntity.ok(purchaseTypes);
    }

    @PostMapping
    public ResponseEntity<PurchaseType> createPurchaseType(@RequestBody PurchaseType purchaseType) {
        PurchaseType createdPurchaseType = purchaseTypeService.save(purchaseType);
        return ResponseEntity.status(201).body(createdPurchaseType);
    }

    // Add other endpoints as necessary
}


properties
# application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true



package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
