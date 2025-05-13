
package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "size_wise_detail")
@Getter
@Setter
public class SizeWiseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "actual_qty")
    private BigDecimal actualQty;

    @Column(name = "add_deduct")
    private BigDecimal addDeduct;

    @Column(name = "bom_rmline_id")
    private BigDecimal bomRmlineId;

    @Column(name = "booking_percent")
    private BigDecimal bookingPercent;

    @Column(name = "det_id")
    private BigDecimal detId;

    @Column(name = "size_val")
    private String sizeVal;

    @Column(name = "size_wise_bom_req_qty")
    private BigDecimal sizeWiseBomReqQty;

    @Column(name = "size_wise_order_qty")
    private BigDecimal sizeWiseOrderQty;

    @Column(name = "size_wise_proj_qty")
    private BigDecimal sizeWiseProjQty;

    @Column(name = "flag")
    private String flag;

    @Transient
    private BigDecimal actualQtyTotal;

    public BigDecimal calculateActualQtyTotal(List<SizeWiseDetail> details) {
        return details.stream()
                .map(SizeWiseDetail::getActualQty)
                .filter(qty -> qty != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}



package com.example.demo.repository;

import com.example.demo.model.SizeWiseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeWiseDetailRepository extends JpaRepository<SizeWiseDetail, Long> {
}



package com.example.demo.service;

import com.example.demo.model.SizeWiseDetail;
import com.example.demo.repository.SizeWiseDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizeWiseDetailService {

    private final SizeWiseDetailRepository repository;

    @Transactional(readOnly = true)
    public List<SizeWiseDetail> findAll() {
        return repository.findAll();
    }

    @Transactional
    public SizeWiseDetail save(SizeWiseDetail sizeWiseDetail) {
        return repository.save(sizeWiseDetail);
    }

    @Transactional(readOnly = true)
    public BigDecimal calculateTotalActualQty(List<SizeWiseDetail> details) {
        return new SizeWiseDetail().calculateActualQtyTotal(details);
    }
}



package com.example.demo.controller;

import com.example.demo.model.SizeWiseDetail;
import com.example.demo.service.SizeWiseDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/size-wise-details")
@RequiredArgsConstructor
public class SizeWiseDetailController {

    private final SizeWiseDetailService service;

    @GetMapping
    public ResponseEntity<List<SizeWiseDetail>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<SizeWiseDetail> create(@RequestBody SizeWiseDetail sizeWiseDetail) {
        return ResponseEntity.ok(service.save(sizeWiseDetail));
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



package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
