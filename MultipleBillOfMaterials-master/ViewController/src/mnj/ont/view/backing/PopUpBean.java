
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

    @PostMapping("/createPoDff")
    public void createPoDff() {
        appModuleService.createPoDff();
    }

    @PostMapping("/saveAndCreatePo")
    @Transactional
    public void saveAndCreatePo() {
        appModuleService.saveAndCreatePo();
    }

    @GetMapping("/fillMaterial")
    public void fillMaterial() {
        appModuleService.fillMaterial();
    }

    // Additional methods for handling popup events can be added here
}



package com.example.demo.service;

import com.example.demo.repository.AppModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AppModuleService {

    private final AppModuleRepository appModuleRepository;

    @Autowired
    public AppModuleService(AppModuleRepository appModuleRepository) {
        this.appModuleRepository = appModuleRepository;
    }

    public void createPoDff() {
        String currentBomId = appModuleRepository.getCurrentBomId();
        String orgId = appModuleRepository.getOrgId();
        appModuleRepository.createPoDff(currentBomId, orgId);
    }

    @Transactional
    public void saveAndCreatePo() {
        appModuleRepository.commitTransaction();
        appModuleRepository.executeAutoPoProcedure();
    }

    public void fillMaterial() {
        appModuleRepository.callMatFetch();
    }
}



package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class AppModuleRepository {

    private final DataSource dataSource;

    @Autowired
    public AppModuleRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getCurrentBomId() {
        // Logic to retrieve current BOM ID from the database
    }

    public String getOrgId() {
        // Logic to retrieve Org ID from the database
    }

    public void createPoDff(String currentBomId, String orgId) {
        // Logic to create PO DFF in the database
    }

    public void commitTransaction() {
        // Logic to commit transaction
    }

    public void executeAutoPoProcedure() {
        String stmt = "BEGIN APPS.CREATE_AUTO_PO(:1,:2,:3,:4,:5); end;";
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(stmt)) {
            cs.registerOutParameter(1, java.sql.Types.VARCHAR);
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            // Set other parameters
            cs.execute();
        } catch (SQLException e) {
            log.error("Error executing stored procedure", e);
        }
    }

    public void callMatFetch() {
        // Logic to call the material fetch operation
    }
}


yaml
# application.yml
spring:
  datasource:
    url: jdbc:oracle:thin:@//localhost:1521/yourdb
    username: yourusername
    password: yourpassword
    driver-class-name: oracle.jdbc.OracleDriver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true


This code replaces the WebLogic-specific components with Spring Boot equivalents, ensuring that the application is idiomatic to Spring Boot and follows best practices.