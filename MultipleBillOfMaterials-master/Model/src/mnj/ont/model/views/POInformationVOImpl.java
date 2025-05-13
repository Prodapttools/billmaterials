
package com.example.demo.model;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "purchase_order_information")
public class POInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bom_no")
    private String bomNo;

    // Other fields, getters, and setters
}

@Repository
public interface POInformationRepository extends JpaRepository<POInformation, Long> {
    List<POInformation> findByBomNo(String bomNo);
}

@Service
public class POInformationService {

    private final POInformationRepository poInformationRepository;

    public POInformationService(POInformationRepository poInformationRepository) {
        this.poInformationRepository = poInformationRepository;
    }

    @Transactional(readOnly = true)
    public List<POInformation> getPOInformationByBomNo(String bomNo) {
        return poInformationRepository.findByBomNo(bomNo);
    }
}

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/po-information")
public class POInformationController {

    private final POInformationService poInformationService;

    public POInformationController(POInformationService poInformationService) {
        this.poInformationService = poInformationService;
    }

    @GetMapping
    public List<POInformation> getPOInformation(@RequestParam String bomNo) {
        return poInformationService.getPOInformationByBomNo(bomNo);
    }
}


### application.properties
properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


### Additional Configuration

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppConfig {
    // Additional configuration if needed
}
