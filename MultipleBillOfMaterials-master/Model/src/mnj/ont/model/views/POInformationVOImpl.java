
package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POInformationRepository extends JpaRepository<POInformation, Long> {
    // Custom query methods can be defined here
}

package com.example.demo.service;

import com.example.demo.model.POInformation;
import com.example.demo.model.POInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class POInformationService {

    private final POInformationRepository poInformationRepository;

    @Transactional(readOnly = true)
    public List<POInformation> findByBOMNo(String bomNo) {
        return poInformationRepository.findByBOMNo(bomNo);
    }

    // Other service methods can be added here
}

package com.example.demo.controller;

import com.example.demo.model.POInformation;
import com.example.demo.service.POInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/po-information")
@RequiredArgsConstructor
public class POInformationController {

    private final POInformationService poInformationService;

    @GetMapping("/bom/{bomNo}")
    public List<POInformation> getPOInformationByBOMNo(@PathVariable String bomNo) {
        return poInformationService.findByBOMNo(bomNo);
    }

    // Other endpoints can be added here
}

package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PO_INFORMATION")
public class POInformation {

    @Id
    private Long id; // Assuming there's an ID field

    private String bomNo; // Assuming BOM_NO is a field

    // Other fields, getters, and setters can be added here

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBomNo() {
        return bomNo;
    }

    public void setBomNo(String bomNo) {
        this.bomNo = bomNo;
    }
}


### application.properties
properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


### Note
- Ensure to replace the database connection details in `application.properties` with your actual database configuration.
- The `POInformation` entity class should be updated with all relevant fields and their mappings as per your database schema.