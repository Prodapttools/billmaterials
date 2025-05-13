
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bom_header")
public class BomHeader {

    @Id
    private String userId;
    private String buyerName;

    public BomHeader() {
    }

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
}



package com.example.demo.repository;

import com.example.demo.model.BomHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BomHeaderRepository extends JpaRepository<BomHeader, String> {
}



package com.example.demo.service;

import com.example.demo.model.BomHeader;
import com.example.demo.repository.BomHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BomHeaderService {

    private final BomHeaderRepository bomHeaderRepository;

    @Autowired
    public BomHeaderService(BomHeaderRepository bomHeaderRepository) {
        this.bomHeaderRepository = bomHeaderRepository;
    }

    @Transactional(readOnly = true)
    public Optional<BomHeader> findByUserId(String userId) {
        return bomHeaderRepository.findById(userId);
    }

    @Transactional
    public BomHeader save(BomHeader bomHeader) {
        return bomHeaderRepository.save(bomHeader);
    }
}



package com.example.demo.controller;

import com.example.demo.model.BomHeader;
import com.example.demo.service.BomHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/bom-headers")
public class BomHeaderController {

    private final BomHeaderService bomHeaderService;

    @Autowired
    public BomHeaderController(BomHeaderService bomHeaderService) {
        this.bomHeaderService = bomHeaderService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<BomHeader> getBomHeader(@PathVariable String userId) {
        Optional<BomHeader> bomHeader = bomHeaderService.findByUserId(userId);
        return bomHeader.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BomHeader> createBomHeader(@RequestBody BomHeader bomHeader) {
        BomHeader savedBomHeader = bomHeaderService.save(bomHeader);
        return ResponseEntity.ok(savedBomHeader);
    }
}


properties
# application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
