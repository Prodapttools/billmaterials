
package com.example.mnjont.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CUST_MNJ_ONT_BOM_OBLINE_DETAILS")
public class CustMnjOntBomOblineDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOM_ID")
    private BigDecimal bomId;

    @Column(name = "BOM_RMLINE_ID")
    private BigDecimal bomRmlineId;

    @Column(name = "BOM_OBLINE_ID")
    private BigDecimal bomOblineId;

    @Column(name = "SOLINE_ID")
    private BigDecimal solineId;

    @Column(name = "SO_OBNO")
    private String soObno;

    @Column(name = "INSEAM_ID")
    private String inseamId;

    @Column(name = "SIZE_ID")
    private String sizeId;

    @Column(name = "LINEREFNO")
    private String linerefno;

    @Column(name = "BARCODE")
    private String barcode;

    @Column(name = "RELEASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "VERSION_NUMBER")
    private BigDecimal versionNumber;

    @Column(name = "VERSION_DATE")
    @Temporal(TemporalType.DATE)
    private Date versionDate;

    @Column(name = "LINK_OAF_ID")
    private BigDecimal linkOafId;

    @Column(name = "EFFECTIVE_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date effectiveStartDate;

    @Column(name = "EFFECTIVE_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date effectiveEndDate;

    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastUpdateDate;

    @Column(name = "LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "CREATED_BY")
    private BigDecimal createdBy;

    @Column(name = "SIZE_QUANTITY")
    private BigDecimal sizeQuantity;

    @Column(name = "ITEM_CODE")
    private String itemCode;

    @Column(name = "LINE_NO")
    private BigDecimal lineNo;

    @Column(name = "INVENTORY_ITEM_ID")
    private BigDecimal inventoryItemId;

    @Column(name = "CONSUMPTION")
    private BigDecimal consumption;

    @Column(name = "WITH_EXTRA")
    private BigDecimal withExtra;

    @Column(name = "LEGACY_BOMTRID")
    private String legacyBomtrid;

    @Column(name = "LEGACY_BOMTR_CID")
    private String legacyBomtrCid;

    @Column(name = "LEGACY_ID")
    private String legacyId;

    @Column(name = "CUT_P")
    private BigDecimal cutP;

    @Column(name = "LAST_UPDATE_LOGIN")
    private BigDecimal lastUpdateLogin;

    @Column(name = "ATTRIBUTE1")
    private String attribute1;

    @Column(name = "ATTRIBUTE2")
    private String attribute2;

    @Column(name = "ATTRIBUTE3")
    private String attribute3;

    @Column(name = "ATTRIBUTE4")
    private String attribute4;

    @Column(name = "ATTRIBUTE5")
    private String attribute5;

    @Column(name = "ATTRIBUTE6")
    private String attribute6;

    @Column(name = "ATTRIBUTE7")
    private String attribute7;

    @Column(name = "ATTRIBUTE8")
    private String attribute8;

    @Column(name = "ATTRIBUTE9")
    private String attribute9;

    @Column(name = "ATTRIBUTE10")
    private String attribute10;

    @Column(name = "ATTRIBUTE11")
    private String attribute11;

    @Column(name = "ATTRIBUTE12")
    private String attribute12;

    @Column(name = "ATTRIBUTE13")
    private String attribute13;

    @Column(name = "ATTRIBUTE14")
    private String attribute14;

    @Column(name = "ATTRIBUTE15")
    private String attribute15;

    @Transient
    private BigDecimal consExtra;

    @Transient
    private String memoQty;

    @Transient
    private String additional;

    @Transient
    private String inseam;

    @Column(name = "DCPO_NO")
    private String dcpoNo;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "SIZE_VAL")
    private String sizeVal;

    @Column(name = "PO_QTY")
    private BigDecimal poQty;

    @Transient
    private BigDecimal totalQty;

    // Additional methods for calculated fields can be added here
}



package com.example.mnjont.controller;

import com.example.mnjont.model.CustMnjOntBomOblineDetails;
import com.example.mnjont.service.CustMnjOntBomOblineDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bom-obline-details")
public class CustMnjOntBomOblineDetailsController {

    @Autowired
    private CustMnjOntBomOblineDetailsService service;

    @GetMapping
    public List<CustMnjOntBomOblineDetails> getAllDetails() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CustMnjOntBomOblineDetails getDetailById(@PathVariable BigDecimal id) {
        return service.findById(id);
    }

    @PostMapping
    public CustMnjOntBomOblineDetails createDetail(@RequestBody CustMnjOntBomOblineDetails detail) {
        return service.save(detail);
    }

    @PutMapping("/{id}")
    public CustMnjOntBomOblineDetails updateDetail(@PathVariable BigDecimal id, @RequestBody CustMnjOntBomOblineDetails detail) {
        return service.update(id, detail);
    }

    @DeleteMapping("/{id}")
    public void deleteDetail(@PathVariable BigDecimal id) {
        service.delete(id);
    }
}



package com.example.mnjont.service;

import com.example.mnjont.model.CustMnjOntBomOblineDetails;
import com.example.mnjont.repository.CustMnjOntBomOblineDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class CustMnjOntBomOblineDetailsService {

    @Autowired
    private CustMnjOntBomOblineDetailsRepository repository;

    public List<CustMnjOntBomOblineDetails> findAll() {
        return repository.findAll();
    }

    public CustMnjOntBomOblineDetails findById(BigDecimal id) {
        return repository.findById(id).orElse(null);
    }

    public CustMnjOntBomOblineDetails save(CustMnjOntBomOblineDetails detail) {
        return repository.save(detail);
    }

    public CustMnjOntBomOblineDetails update(BigDecimal id, CustMnjOntBomOblineDetails detail) {
        detail.setBomId(id);
        return repository.save(detail);
    }

    public void delete(BigDecimal id) {
        repository.deleteById(id);
    }
}



package com.example.mnjont.repository;

import com.example.mnjont.model.CustMnjOntBomOblineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CustMnjOntBomOblineDetailsRepository extends JpaRepository<CustMnjOntBomOblineDetails, BigDecimal> {
}


properties
# application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


This code provides a complete migration from the WebLogic-based Java EE application to a modern Spring Boot application, including entity, controller, service, and repository layers, along with the necessary configuration.