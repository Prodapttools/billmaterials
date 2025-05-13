
package com.example.demo.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "BOM_BPO_LINES_ALL")
@Getter
@Setter
public class BomBpoLinesAll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BOM_ID")
    private Long bomId;

    @Column(name = "BPO_NO")
    private String bpoNo;

    @Column(name = "END_USER_DESC")
    private String endUserDesc;

    @Column(name = "FIT")
    private String fit;

    @Column(name = "LINE_ID")
    private Long lineId;

    @Column(name = "ORDER_QTY")
    private Long orderQty;

    @Column(name = "SALE_ORDER_ID")
    private Long saleOrderId;

    @Column(name = "USER_ITEM_DESC")
    private String userItemDesc;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "STYLE_NO")
    private String styleNo;

    @Column(name = "SEASON")
    private String season;

    @Transient
    private Long totOrdQty;

    @Transient
    private BigDecimal totalOrderQty;

    public BigDecimal calculateTotalOrderQty(List<BomBpoLinesAll> lines) {
        BigDecimal total = BigDecimal.ZERO;
        for (BomBpoLinesAll line : lines) {
            total = total.add(BigDecimal.valueOf(line.getOrderQty()));
        }
        return total;
    }
}

@Service
public class BomBpoLinesAllService {

    private final BomBpoLinesAllRepository repository;

    public BomBpoLinesAllService(BomBpoLinesAllRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<BomBpoLinesAll> findAll() {
        return repository.findAll();
    }

    @Transactional
    public BomBpoLinesAll save(BomBpoLinesAll bomBpoLinesAll) {
        return repository.save(bomBpoLinesAll);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

@Repository
public interface BomBpoLinesAllRepository extends JpaRepository<BomBpoLinesAll, Long> {
}


### Application Properties (application.properties)
properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


### Controller Example

package com.example.demo.controller;

import com.example.demo.model.BomBpoLinesAll;
import com.example.demo.model.BomBpoLinesAllService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bom-bpo-lines")
public class BomBpoLinesAllController {

    private final BomBpoLinesAllService service;

    public BomBpoLinesAllController(BomBpoLinesAllService service) {
        this.service = service;
    }

    @GetMapping
    public List<BomBpoLinesAll> getAll() {
        return service.findAll();
    }

    @PostMapping
    public BomBpoLinesAll create(@RequestBody BomBpoLinesAll bomBpoLinesAll) {
        return service.save(bomBpoLinesAll);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
