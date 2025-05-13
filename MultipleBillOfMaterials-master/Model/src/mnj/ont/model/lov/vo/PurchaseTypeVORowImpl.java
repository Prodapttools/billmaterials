
package com.example.demo.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class PurchaseType {
    
    @Id
    private Long id; // Assuming there's an ID field, adjust as necessary

    // Add other fields and their mappings here
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
@Transactional
public class PurchaseTypeService {

    private final PurchaseTypeRepository purchaseTypeRepository;

    @Autowired
    public PurchaseTypeService(PurchaseTypeRepository purchaseTypeRepository) {
        this.purchaseTypeRepository = purchaseTypeRepository;
    }

    public List<PurchaseType> findAll() {
        return purchaseTypeRepository.findAll();
    }

    public PurchaseType findById(Long id) {
        return purchaseTypeRepository.findById(id).orElse(null);
    }

    public PurchaseType save(PurchaseType purchaseType) {
        return purchaseTypeRepository.save(purchaseType);
    }

    public void deleteById(Long id) {
        purchaseTypeRepository.deleteById(id);
    }
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
    public List<PurchaseType> getAllPurchaseTypes() {
        return purchaseTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseType> getPurchaseTypeById(@PathVariable Long id) {
        PurchaseType purchaseType = purchaseTypeService.findById(id);
        return purchaseType != null ? ResponseEntity.ok(purchaseType) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public PurchaseType createPurchaseType(@RequestBody PurchaseType purchaseType) {
        return purchaseTypeService.save(purchaseType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseType(@PathVariable Long id) {
        purchaseTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
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
