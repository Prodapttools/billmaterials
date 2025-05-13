
package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "size_wise_detail")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SizeWiseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "actual_qty")
    private Double actualQty;

    @Column(name = "add_deduct")
    private Double addDeduct;

    @Column(name = "bom_rmline_id")
    private Double bomRmlineId;

    @Column(name = "booking_percent")
    private Double bookingPercent;

    @Column(name = "det_id")
    private Double detId;

    @Column(name = "size_val")
    private String sizeVal;

    @Column(name = "size_wise_bom_req_qty")
    private Double sizeWiseBomReqQty;

    @Column(name = "size_wise_order_qty")
    private Double sizeWiseOrderQty;

    @Column(name = "size_wise_proj_qty")
    private Double sizeWiseProjQty;

    @Column(name = "flag")
    private String flag;

    @Transient
    private Double actualQtyTotal;

    public Double calculateActualQtyTotal(List<SizeWiseDetail> details) {
        return details.stream()
                .map(SizeWiseDetail::getActualQty)
                .filter(Objects::nonNull)
                .reduce(0.0, Double::sum);
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SizeWiseDetailService {

    private final SizeWiseDetailRepository repository;

    @Autowired
    public SizeWiseDetailService(SizeWiseDetailRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<SizeWiseDetail> findAll() {
        return repository.findAll();
    }

    @Transactional
    public SizeWiseDetail save(SizeWiseDetail sizeWiseDetail) {
        return repository.save(sizeWiseDetail);
    }

    @Transactional(readOnly = true)
    public Double calculateTotalActualQty(List<SizeWiseDetail> details) {
        return new SizeWiseDetail().calculateActualQtyTotal(details);
    }
}



package com.example.demo.controller;

import com.example.demo.model.SizeWiseDetail;
import com.example.demo.service.SizeWiseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/size-wise-details")
public class SizeWiseDetailController {

    private final SizeWiseDetailService service;

    @Autowired
    public SizeWiseDetailController(SizeWiseDetailService service) {
        this.service = service;
    }

    @GetMapping
    public List<SizeWiseDetail> getAll() {
        return service.findAll();
    }

    @PostMapping
    public SizeWiseDetail create(@RequestBody SizeWiseDetail sizeWiseDetail) {
        return service.save(sizeWiseDetail);
    }

    @GetMapping("/calculate-total")
    public Double calculateTotal(@RequestBody List<SizeWiseDetail> details) {
        return service.calculateTotalActualQty(details);
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



package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
