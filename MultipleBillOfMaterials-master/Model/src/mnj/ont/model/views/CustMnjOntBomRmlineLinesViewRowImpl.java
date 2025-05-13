
package com.example.mnj.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cust_mnj_ont_bom_rmline_lines")
@Getter
@Setter
public class CustMnjOntBomRmlineLines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_desc")
    private String itemDesc;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "legacy_code")
    private String legacyCode;

    @Column(name = "pr_qty")
    private BigDecimal prQty;

    @Column(name = "line_status")
    private String lineStatus;

    // Additional fields for relationships can be added here
    // For example, if you have relationships with other entities, you can use @OneToMany, @ManyToOne, etc.
}



package com.example.mnj.repository;

import com.example.mnj.model.CustMnjOntBomRmlineLines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustMnjOntBomRmlineLinesRepository extends JpaRepository<CustMnjOntBomRmlineLines, Long> {
    // Custom query methods can be defined here
}



package com.example.mnj.service;

import com.example.mnj.model.CustMnjOntBomRmlineLines;
import com.example.mnj.repository.CustMnjOntBomRmlineLinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustMnjOntBomRmlineLinesService {

    private final CustMnjOntBomRmlineLinesRepository repository;

    @Autowired
    public CustMnjOntBomRmlineLinesService(CustMnjOntBomRmlineLinesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<CustMnjOntBomRmlineLines> findAll() {
        return repository.findAll();
    }

    @Transactional
    public CustMnjOntBomRmlineLines save(CustMnjOntBomRmlineLines line) {
        return repository.save(line);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}



package com.example.mnj.controller;

import com.example.mnj.model.CustMnjOntBomRmlineLines;
import com.example.mnj.service.CustMnjOntBomRmlineLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rmline-lines")
public class CustMnjOntBomRmlineLinesController {

    private final CustMnjOntBomRmlineLinesService service;

    @Autowired
    public CustMnjOntBomRmlineLinesController(CustMnjOntBomRmlineLinesService service) {
        this.service = service;
    }

    @GetMapping
    public List<CustMnjOntBomRmlineLines> getAll() {
        return service.findAll();
    }

    @PostMapping
    public CustMnjOntBomRmlineLines create(@RequestBody CustMnjOntBomRmlineLines line) {
        return service.save(line);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
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



package com.example.mnj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MnjApplication {
    public static void main(String[] args) {
        SpringApplication.run(MnjApplication.class, args);
    }
}
