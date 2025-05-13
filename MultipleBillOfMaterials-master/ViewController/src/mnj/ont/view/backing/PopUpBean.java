
package com.example.demo.controller;

import com.example.demo.service.AppModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Slf4j
@RestController
@RequestMapping("/api/popup")
public class PopUpController {

    private final AppModuleService appModuleService;

    @Autowired
    public PopUpController(AppModuleService appModuleService) {
        this.appModuleService = appModuleService;
    }

    @GetMapping("/matTable")
    public RichTable getMatTable() {
        return appModuleService.getMatTable();
    }

    @PostMapping("/fillMaterial")
    @Transactional
    public void fillMaterial() {
        appModuleService.fillMaterial();
    }

    @PostMapping("/createPoDff")
    @Transactional
    public void createPoDff() {
        appModuleService.createPoDff();
    }

    @PostMapping("/saveAndCreatePo")
    @Transactional
    public void saveAndCreatePo() {
        appModuleService.saveAndCreatePo();
    }

    @PostMapping("/editDialog")
    public void editDialog(@RequestParam String outcome) {
        if ("ok".equalsIgnoreCase(outcome)) {
            fillMaterial();
        } else if ("cancel".equalsIgnoreCase(outcome)) {
            // Handle cancel logic if needed
        }
    }
}



package com.example.demo.service;

import com.example.demo.repository.AppModuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class AppModuleService {

    private final AppModuleRepository appModuleRepository;

    @Autowired
    public AppModuleService(AppModuleRepository appModuleRepository) {
        this.appModuleRepository = appModuleRepository;
    }

    public RichTable getMatTable() {
        return appModuleRepository.getMatTable();
    }

    @Transactional
    public void fillMaterial() {
        appModuleRepository.callMatFetch();
    }

    @Transactional
    public void createPoDff() {
        appModuleRepository.createPoDff();
    }

    @Transactional
    public void saveAndCreatePo() {
        appModuleRepository.saveAndCreatePo();
    }
}



package com.example.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AppModuleRepository {

    // Assume necessary JPA or JDBC template is injected here

    public RichTable getMatTable() {
        // Logic to retrieve the RichTable
    }

    public void callMatFetch() {
        // Logic to call the material fetch operation
    }

    public void createPoDff() {
        // Logic to create PO DFF
    }

    public void saveAndCreatePo() {
        // Logic to save and create PO
    }
}



// application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


### Note:
- The `RichTable` class and its methods need to be defined or replaced with appropriate Spring components.
- The `AppModuleImpl` logic should be refactored into the `AppModuleRepository` methods.
- Ensure that the database operations are properly handled using Spring Data JPA or JDBC templates as needed.
- The error handling and logging should be enhanced as per the application's requirements.