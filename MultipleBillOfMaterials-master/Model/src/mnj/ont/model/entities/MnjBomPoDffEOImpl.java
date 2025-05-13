
package mnj.ont.model.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "MNJ_BOM_PO_DFF")
@Getter
@Setter
@Component
public class MnjBomPoDffEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HEADER_ID")
    private Long headerId;

    @Column(name = "BOM_ID")
    private Long bomId;

    @Column(name = "ORG_ID")
    private Long orgId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "PR_NO")
    private Long prNo;

    @Column(name = "PURCHASE_MODE")
    private String purchaseMode;

    @Column(name = "SHIP_MODE")
    private String shipMode;

    @Column(name = "DELIVERY_TERM")
    private String deliveryTerm;

    @Column(name = "SPO_TYPE")
    private String spoType;

    @Column(name = "NOMINATED_BY")
    private String nominatedBy;

    @Column(name = "PARTIAL_SHIPMENT")
    private String partialShipment;

    @Column(name = "EXCESS_SHIPMENT")
    private String excessShipment;

    @Column(name = "ACTUAL_SUPPLIER")
    private String actualSupplier;

    @Column(name = "ACTUAL_SUPPLIER_ID")
    private Long actualSupplierId;

    @ManyToOne
    @JoinColumn(name = "CUST_MNJ_ONT_BOM_HEADER_ID")
    private CustMnjOntBomHeaderImpl custMnjOntBomHeader;

    @PrePersist
    public void prePersist() {
        // Logic to set default values before persisting
        this.userId = 2222L; // Replace with actual user retrieval logic
        this.orgId = 2222L; // Replace with actual org retrieval logic
    }
}



package mnj.ont.model.repositories;

import mnj.ont.model.entities.MnjBomPoDffEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MnjBomPoDffRepository extends JpaRepository<MnjBomPoDffEO, Long> {
}



package mnj.ont.model.services;

import mnj.ont.model.entities.MnjBomPoDffEO;
import mnj.ont.model.repositories.MnjBomPoDffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MnjBomPoDffService {

    @Autowired
    private MnjBomPoDffRepository repository;

    @Transactional
    public MnjBomPoDffEO create(MnjBomPoDffEO entity) {
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<MnjBomPoDffEO> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public MnjBomPoDffEO findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}



package mnj.ont.controllers;

import mnj.ont.model.entities.MnjBomPoDffEO;
import mnj.ont.model.services.MnjBomPoDffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mnj-bom-po-dff")
public class MnjBomPoDffController {

    @Autowired
    private MnjBomPoDffService service;

    @PostMapping
    public ResponseEntity<MnjBomPoDffEO> create(@RequestBody MnjBomPoDffEO entity) {
        MnjBomPoDffEO createdEntity = service.create(entity);
        return ResponseEntity.ok(createdEntity);
    }

    @GetMapping
    public ResponseEntity<List<MnjBomPoDffEO>> findAll() {
        List<MnjBomPoDffEO> entities = service.findAll();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MnjBomPoDffEO> findById(@PathVariable Long id) {
        MnjBomPoDffEO entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
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



package mnj.ont;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MnjApplication {
    public static void main(String[] args) {
        SpringApplication.run(MnjApplication.class, args);
    }
}
