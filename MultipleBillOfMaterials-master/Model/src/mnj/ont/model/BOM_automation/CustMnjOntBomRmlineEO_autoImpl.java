
package mnj.ont.model.BOM_automation;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CUST_MNJ_ONT_BOM_RMLINE")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustMnjOntBomRmline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bomRmlineId;

    private Long bomId;
    private String itemCategoryId;
    private String itemCode;
    private String measureUnitId;
    private BigDecimal noOfGarment;
    private BigDecimal usageMoUnit;
    private BigDecimal extraUsage;
    private BigDecimal rate;
    private String itemRefNo;
    private String productionArea;
    private String rmPlacement;
    private String rmInstruction;
    private Long preCostingLineno;
    private Date releaseDate;
    private Long versionNumber;
    private Date versionDate;
    private Long linkOafId;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private Date lastUpdateDate;
    private Long lastUpdatedBy;
    private Date creationDate;
    private Long createdBy;
    private Long inventoryItemId;
    private String itemPrefix;
    private Long processId;
    private String processDesc;
    private String rmlineType;
    private String printPageSide;
    private String legacyBomid;
    private String legacyBomtrid;
    private String legacyBomtrCid;
    private BigDecimal coneDesc;
    private BigDecimal coneValue;
    private BigDecimal noOfCones;
    private String threadUnit;
    private String requestType;
    private String pDesc;
    private String pName;
    private Long position;
    private BigDecimal cutP;
    private Long lastUpdateLogin;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;
    private String attribute8;
    private String attribute9;
    private String attribute10;
    private String attribute11;
    private String attribute12;
    private String attribute13;
    private String attribute14;
    private String attribute15;
    private Long vendorId;
    private BigDecimal bookedQty;
    private String flag;
    private String bookingUom;
    private BigDecimal poQty;
    private Date deliveryDate1;
    private Date deliveryDate2;
    private Date deliveryDate3;
    private Date deliveryDate4;
    private Date deliveryDate5;
    private BigDecimal qty1;
    private BigDecimal qty2;
    private BigDecimal qty3;
    private BigDecimal qty4;
    private BigDecimal qty5;
    private BigDecimal uomConvRate;
    private BigDecimal onhandQuantity;
    private BigDecimal allocateQty;
    private BigDecimal onhandQty1;
    private BigDecimal allocateQty1;
    private BigDecimal alocateIntrQty;
    private BigDecimal onhandCgl;
    private BigDecimal onhahndGfl;
    private BigDecimal alocateCgl;
    private BigDecimal alocateGfl;
    private BigDecimal alocateIntrCgl;
    private BigDecimal alocateInterGfl;
    private Long orgIdCal;
    private Long orgIdCgl;
    private Long orgIdGfl;
    private String approvalFlag;
    private String excesBuyReason;
    private BigDecimal pricePerUnit;
    private BigDecimal total;
    private BigDecimal perntg;
    private BigDecimal projPrQty;
    private Long lineId;
    private BigDecimal leftOverQty;
    private BigDecimal additionalQty;
    private BigDecimal actualPrcnt;
    private BigDecimal pendingPrcnt;
    private BigDecimal accumPrcnt;
    private BigDecimal transferQty;
    private String currency;
    private String purchaseType;
    private BigDecimal totalQuantity;
    private String remarks;

    @PrePersist
    public void prePersist() {
        this.currency = "USD";
        this.purchaseType = "Non-Generic";
    }
}



package mnj.ont.controller;

import mnj.ont.model.BOM_automation.CustMnjOntBomRmline;
import mnj.ont.service.CustMnjOntBomRmlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bom-rmline")
public class CustMnjOntBomRmlineController {

    @Autowired
    private CustMnjOntBomRmlineService service;

    @GetMapping
    public List<CustMnjOntBomRmline> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustMnjOntBomRmline> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CustMnjOntBomRmline create(@RequestBody CustMnjOntBomRmline bomRmline) {
        return service.save(bomRmline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustMnjOntBomRmline> update(@PathVariable Long id, @RequestBody CustMnjOntBomRmline bomRmline) {
        return service.update(id, bomRmline)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}



package mnj.ont.service;

import mnj.ont.model.BOM_automation.CustMnjOntBomRmline;
import mnj.ont.repository.CustMnjOntBomRmlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustMnjOntBomRmlineService {

    @Autowired
    private CustMnjOntBomRmlineRepository repository;

    public List<CustMnjOntBomRmline> findAll() {
        return repository.findAll();
    }

    public Optional<CustMnjOntBomRmline> findById(Long id) {
        return repository.findById(id);
    }

    public CustMnjOntBomRmline save(CustMnjOntBomRmline bomRmline) {
        return repository.save(bomRmline);
    }

    public Optional<CustMnjOntBomRmline> update(Long id, CustMnjOntBomRmline bomRmline) {
        if (repository.existsById(id)) {
            bomRmline.setBomRmlineId(id);
            return Optional.of(repository.save(bomRmline));
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}



package mnj.ont.repository;

import mnj.ont.model.BOM_automation.CustMnjOntBomRmline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustMnjOntBomRmlineRepository extends JpaRepository<CustMnjOntBomRmline, Long> {
}


yaml
# application.yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database
    username: your_username
    password: your_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BomAutomationApplication {
    public static void main(String[] args) {
        SpringApplication.run(BomAutomationApplication.class, args);
    }
}
