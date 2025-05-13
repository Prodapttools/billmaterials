
package mnj.ont.model.entities;

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
public class CustMnjOntBomRmlineLines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bomRmlineId;

    private BigDecimal bomId;
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
    private BigDecimal preCostingLineno;
    private Date releaseDate;
    private BigDecimal versionNumber;
    private Date versionDate;
    private BigDecimal linkOafId;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private Date lastUpdateDate;
    private Long lastUpdatedBy;
    private Date creationDate;
    private Long createdBy;
    private BigDecimal inventoryItemId;
    private String itemPrefix;
    private BigDecimal processId;
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
    private BigDecimal position;
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
    private BigDecimal vendorId;
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
    private BigDecimal orgIdCal;
    private BigDecimal orgIdCgl;
    private BigDecimal orgIdGfl;
    private String approvalFlag;
    private String excesBuyReason;
    private BigDecimal lineId;
    private BigDecimal pricePerUnit;
    private BigDecimal total;
    private BigDecimal perntg;
    private BigDecimal projPrQty;
    private BigDecimal leftOverQty;
    private BigDecimal additionalQty;
    private BigDecimal actualPrcnt;
    private BigDecimal pendingPrcnt;
    private BigDecimal accumPrcnt;
    private BigDecimal transferQty;
    private String currency;
    private String purchaseType;
    private String remarks;

    // Custom methods for business logic can be added here
}


### Repository Interface

package mnj.ont.repository;

import mnj.ont.model.entities.CustMnjOntBomRmlineLines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustMnjOntBomRmlineLinesRepository extends JpaRepository<CustMnjOntBomRmlineLines, Long> {
    // Custom query methods can be defined here
}


### Service Class

package mnj.ont.service;

import mnj.ont.model.entities.CustMnjOntBomRmlineLines;
import mnj.ont.repository.CustMnjOntBomRmlineLinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustMnjOntBomRmlineLinesService {

    @Autowired
    private CustMnjOntBomRmlineLinesRepository repository;

    @Transactional
    public CustMnjOntBomRmlineLines save(CustMnjOntBomRmlineLines line) {
        return repository.save(line);
    }

    @Transactional(readOnly = true)
    public List<CustMnjOntBomRmlineLines> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public CustMnjOntBomRmlineLines findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}


### Controller Class

package mnj.ont.controller;

import mnj.ont.model.entities.CustMnjOntBomRmlineLines;
import mnj.ont.service.CustMnjOntBomRmlineLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rmline-lines")
public class CustMnjOntBomRmlineLinesController {

    @Autowired
    private CustMnjOntBomRmlineLinesService service;

    @PostMapping
    public ResponseEntity<CustMnjOntBomRmlineLines> create(@RequestBody CustMnjOntBomRmlineLines line) {
        CustMnjOntBomRmlineLines createdLine = service.save(line);
        return ResponseEntity.ok(createdLine);
    }

    @GetMapping
    public ResponseEntity<List<CustMnjOntBomRmlineLines>> getAll() {
        List<CustMnjOntBomRmlineLines> lines = service.findAll();
        return ResponseEntity.ok(lines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustMnjOntBomRmlineLines> getById(@PathVariable Long id) {
        CustMnjOntBomRmlineLines line = service.findById(id);
        return line != null ? ResponseEntity.ok(line) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


### Application Properties
properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


### Main Application Class

package mnj.ont;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
