
package com.example.demo.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "mnj_bom_bpo_lines_all")
@Getter
@Setter
@Component
public class BomBpoLinesAll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bom_id")
    private Long bomId;

    @Column(name = "bpo_no")
    private String bpoNo;

    @Column(name = "end_user_desc")
    private String endUserDesc;

    @Column(name = "fit")
    private String fit;

    @Column(name = "line_id")
    private Long lineId;

    @Column(name = "order_qty")
    private BigDecimal orderQty;

    @Column(name = "sale_order_id")
    private Long saleOrderId;

    @Column(name = "user_item_desc")
    private String userItemDesc;

    @Column(name = "brand")
    private String brand;

    @Column(name = "style_no")
    private String styleNo;

    @Column(name = "season")
    private String season;

    @Column(name = "tot_ord_qty")
    private BigDecimal totOrdQty;

    @Column(name = "total_order_qty")
    private BigDecimal totalOrderQty;

    @Column(name = "buyer_criteria1")
    private String buyerCriteria1;

    // Additional methods can be added here
}

@Repository
public interface BomBpoLinesAllRepository extends JpaRepository<BomBpoLinesAll, Long> {
    List<BomBpoLinesAll> findByBpoNo(String bpoNo);
}

@Service
public class BomBpoLinesAllService {

    private final BomBpoLinesAllRepository repository;

    public BomBpoLinesAllService(BomBpoLinesAllRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public BigDecimal calculateTotalOrderQty() {
        BigDecimal total = BigDecimal.ZERO;
        List<BomBpoLinesAll> lines = repository.findAll();
        for (BomBpoLinesAll line : lines) {
            total = total.add(line.getOrderQty());
        }
        return total;
    }

    public List<BomBpoLinesAll> getAllLines() {
        return repository.findAll();
    }

    public BomBpoLinesAll getLineById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void saveLine(BomBpoLinesAll line) {
        repository.save(line);
    }
}

@RestController
@RequestMapping("/api/bom-bpo-lines")
public class BomBpoLinesAllController {

    private final BomBpoLinesAllService service;

    public BomBpoLinesAllController(BomBpoLinesAllService service) {
        this.service = service;
    }

    @GetMapping
    public List<BomBpoLinesAll> getAllLines() {
        return service.getAllLines();
    }

    @GetMapping("/{id}")
    public BomBpoLinesAll getLineById(@PathVariable Long id) {
        return service.getLineById(id);
    }

    @PostMapping
    public void createLine(@RequestBody BomBpoLinesAll line) {
        service.saveLine(line);
    }

    @GetMapping("/total-order-qty")
    public BigDecimal getTotalOrderQty() {
        return service.calculateTotalOrderQty();
    }
}
