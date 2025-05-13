
package com.example.mnjont.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CUST_MNJ_ONT_BOM_HEADER")
@Getter
@Setter
@NoArgsConstructor
public class CustMnjOntBomHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HEADER_ID")
    private Long headerId;

    @Column(name = "BOM_ID")
    private Long bomId;

    @Column(name = "BOM_NUMBER")
    private Long bomNumber;

    @Column(name = "BPO_NO")
    private String bpoNo;

    @Column(name = "ORDER_QTY")
    private Long orderQty;

    @Column(name = "BOM_DATE")
    @Temporal(TemporalType.DATE)
    private Date bomDate;

    @Column(name = "SALE_ORDER_ID")
    private Long saleOrderId;

    @Column(name = "ITEM_CODE")
    private String itemCode;

    @Column(name = "BOM_STATUS")
    private String bomStatus;

    @Column(name = "REVISED_REMARKS")
    private String revisedRemarks;

    @Column(name = "RELEASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "VERSION_NUMBER")
    private Long versionNumber;

    @Column(name = "VERSION_DATE")
    @Temporal(TemporalType.DATE)
    private Date versionDate;

    @Column(name = "LINK_OAF_ID")
    private Long linkOafId;

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
    private Long lastUpdatedBy;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Column(name = "LINE_ID")
    private Long lineId;

    @Column(name = "USER_ITEM_DESCRIPTION")
    private String userItemDescription;

    @Column(name = "LEGACY_BOM_ID")
    private String legacyBomid;

    @Column(name = "ORG_ID")
    private Long orgId;

    @Column(name = "POST")
    private String post;

    @Column(name = "LAST_UPDATE_LOGIN")
    private Long lastUpdateLogin;

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

    @Column(name = "SALE_ORDER_NUMBER")
    private Long saleOrderNumber;

    @Column(name = "BUYER")
    private String buyer;

    @Column(name = "SALE_ORDER_NUMBER2")
    private Long saleOrderNumber2;

    @Column(name = "BUYER_ID")
    private Long buyerId;

    @Column(name = "BPO_NO_C")
    private String bpoNoC;

    @Column(name = "BRAND_C")
    private String brandC;

    @Column(name = "END_USER_DESC_C")
    private String endUserDescC;

    @Column(name = "FIT_C")
    private String fitC;

    @Column(name = "ITEM_DESC_C")
    private String itemDescC;

    @Column(name = "ORDER_QTY_C")
    private String orderQtyC;

    @Column(name = "SEASON_C")
    private String seasonC;

    @Column(name = "STYLE_NAME_C")
    private String styleNameC;

    @Column(name = "STYLE_NO_C")
    private String styleNoC;

    @Column(name = "ATTRIBUTE16")
    private String attribute16;

    @Column(name = "ATTRIBUTE17")
    private String attribute17;

    @Column(name = "ATTRIBUTE18")
    private String attribute18;

    @Column(name = "ATTRIBUTE19")
    private String attribute19;

    @Column(name = "ATTRIBUTE20")
    private String attribute20;

    @Column(name = "ATTRIBUTE21")
    private String attribute21;

    @Column(name = "ATTRIBUTE22")
    private String attribute22;

    @Column(name = "ATTRIBUTE23")
    private String attribute23;

    @Column(name = "ATTRIBUTE24")
    private String attribute24;

    @Column(name = "ATTRIBUTE25")
    private String attribute25;

    @Column(name = "ATTRIBUTE26")
    private String attribute26;

    @Column(name = "ATTRIBUTE27")
    private String attribute27;

    @Column(name = "ATTRIBUTE28")
    private String attribute28;

    @Column(name = "ATTRIBUTE29")
    private String attribute29;

    @Column(name = "ATTRIBUTE30")
    private String attribute30;

    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;

    @Column(name = "UNIT_NAME")
    private String unitName;

    @Column(name = "SHIPMENT_UNIT")
    private String shipmentUnit;

    @Column(name = "ATTACHMENT")
    private Long attachment;

    @Column(name = "TOT_ORD_QTY")
    private Long totOrdQty;

    @Column(name = "ORDER_TYPE")
    private String orderType;

    @Column(name = "DIVISION")
    private String division;

    @Column(name = "STYLE_NAME_NEW")
    private String styleNameNew;

    @Column(name = "CURRENT_STYLE_NO")
    private String currentStyleNo;

    @Column(name = "CURRENT_STYLE_NAME")
    private String currentStyleName;

    // Additional relationships can be defined here
}


### Repository Interface

package com.example.mnjont.repository;

import com.example.mnjont.model.CustMnjOntBomHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustMnjOntBomHeaderRepository extends JpaRepository<CustMnjOntBomHeader, Long> {
    // Custom query methods can be defined here
}


### Service Class

package com.example.mnjont.service;

import com.example.mnjont.model.CustMnjOntBomHeader;
import com.example.mnjont.repository.CustMnjOntBomHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustMnjOntBomHeaderService {

    @Autowired
    private CustMnjOntBomHeaderRepository repository;

    @Transactional(readOnly = true)
    public List<CustMnjOntBomHeader> findAll() {
        return repository.findAll();
    }

    @Transactional
    public CustMnjOntBomHeader save(CustMnjOntBomHeader header) {
        return repository.save(header);
    }

    @Transactional(readOnly = true)
    public CustMnjOntBomHeader findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}


### Controller Class

package com.example.mnjont.controller;

import com.example.mnjont.model.CustMnjOntBomHeader;
import com.example.mnjont.service.CustMnjOntBomHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bom-headers")
public class CustMnjOntBomHeaderController {

    @Autowired
    private CustMnjOntBomHeaderService service;

    @GetMapping
    public List<CustMnjOntBomHeader> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustMnjOntBomHeader> getById(@PathVariable Long id) {
        CustMnjOntBomHeader header = service.findById(id);
        return header != null ? ResponseEntity.ok(header) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public CustMnjOntBomHeader create(@RequestBody CustMnjOntBomHeader header) {
        return service.save(header);
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


### Dependencies (Maven)
xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>


This code provides a complete migration from the WebLogic-based Java EE application to a modern Spring Boot application, maintaining the original logic while adhering to Spring Boot best practices.