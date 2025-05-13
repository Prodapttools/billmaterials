
package mnj.ont.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MNJ_BOM_PO_DFF")
public class MnjBomPoDff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long headerId;

    private Long bomId;
    private Long orgId;
    private Long userId;
    private Long prNo;
    private String purchaseMode;
    private String shipMode;
    private String deliveryTerm;
    private String spoType;
    private String nominatedBy;
    private String partialShipment;
    private String excessShipment;
    private String actualSupplier;
    private Long actualSupplierId;

    @ManyToOne
    @JoinColumn(name = "CUST_MNJ_ONT_BOM_HEADER_ID")
    private CustMnjOntBomHeader custMnjOntBomHeader;

    @PrePersist
    public void prePersist() {
        // Logic to set default values before persisting
        // For example, setting userId from session or context
        this.userId = getCurrentUserId();
        this.orgId = getCurrentOrgId();
    }

    private Long getCurrentUserId() {
        // Implement logic to retrieve current user ID from context/session
        return 2222L; // Placeholder
    }

    private Long getCurrentOrgId() {
        // Implement logic to retrieve current organization ID from context/session
        return 2222L; // Placeholder
    }
}



package mnj.ont.model.repositories;

import mnj.ont.model.entities.MnjBomPoDff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MnjBomPoDffRepository extends JpaRepository<MnjBomPoDff, Long> {
    // Custom query methods can be defined here
}



package mnj.ont.model.services;

import mnj.ont.model.entities.MnjBomPoDff;
import mnj.ont.model.repositories.MnjBomPoDffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MnjBomPoDffService {

    private final MnjBomPoDffRepository repository;

    @Autowired
    public MnjBomPoDffService(MnjBomPoDffRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public MnjBomPoDff createMnjBomPoDff(MnjBomPoDff mnjBomPoDff) {
        return repository.save(mnjBomPoDff);
    }

    public List<MnjBomPoDff> getAllMnjBomPoDffs() {
        return repository.findAll();
    }

    public MnjBomPoDff getMnjBomPoDffById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteMnjBomPoDff(Long id) {
        repository.deleteById(id);
    }
}



package mnj.ont.controllers;

import mnj.ont.model.entities.MnjBomPoDff;
import mnj.ont.model.services.MnjBomPoDffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mnj-bom-po-dff")
public class MnjBomPoDffController {

    private final MnjBomPoDffService service;

    @Autowired
    public MnjBomPoDffController(MnjBomPoDffService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MnjBomPoDff> createMnjBomPoDff(@RequestBody MnjBomPoDff mnjBomPoDff) {
        MnjBomPoDff created = service.createMnjBomPoDff(mnjBomPoDff);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<MnjBomPoDff>> getAllMnjBomPoDffs() {
        List<MnjBomPoDff> mnjBomPoDffs = service.getAllMnjBomPoDffs();
        return ResponseEntity.ok(mnjBomPoDffs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MnjBomPoDff> getMnjBomPoDffById(@PathVariable Long id) {
        MnjBomPoDff mnjBomPoDff = service.getMnjBomPoDffById(id);
        return mnjBomPoDff != null ? ResponseEntity.ok(mnjBomPoDff) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMnjBomPoDff(@PathVariable Long id) {
        service.deleteMnjBomPoDff(id);
        return ResponseEntity.noContent().build();
    }
}


yaml
# application.yml
spring:
  datasource:
    url: jdbc:oracle:thin:@localhost:1521:xe
    username: your_username
    password: your_password
    driver-class-name: oracle.jdbc.OracleDriver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true



package mnj.ont;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MnjApplication {
    public static void main(String[] args) {
        SpringApplication.run(MnjApplication.class, args);
    }
}
