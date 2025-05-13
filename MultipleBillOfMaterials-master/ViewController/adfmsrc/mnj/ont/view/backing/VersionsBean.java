
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/versions")
public class VersionsController {

    private static final Logger logger = LoggerFactory.getLogger(VersionsController.class);

    @Autowired
    private VersionService versionService;

    @GetMapping("/bomId")
    public String getBomId() {
        return versionService.getBomId();
    }

    @PostMapping("/versionsAction")
    public void versionsActionListener(@RequestParam("headerNo") String headerNo) {
        logger.info("Value in bean ---> {}", headerNo);
        versionService.setScopeVariable(headerNo);
        logger.info("Scope variable set to ---> {}", versionService.getScopeVariable());
    }

    @GetMapping("/callAttachment")
    public void callAttachment() throws IOException {
        String doc = versionService.getCurrentBomNumber();
        String newPage = "http://192.168.200.115:7003/FileUploading-ViewController-context-root/faces/view1?doc=CD_Invoice_No&docNo=" + doc;
        logger.info("Opening new page: {}", newPage);
        // Logic to open new page in the frontend can be handled by the client-side code
    }

    @PostMapping("/goPrAction")
    public void goPrAction(HttpSession session, @RequestParam("headerNo") String headerNo) {
        session.setAttribute("BOMNO", headerNo);
    }

    @PostMapping("/attachFetch")
    @Transactional
    public void attachFetchListener() {
        Object methodReturnValue = versionService.getAttachments();
        // Logic to update the UI with the fetched attachments
    }

    @PostMapping("/cancelListener")
    public void cancelListener() {
        // Logic for cancel listener
    }
}



package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VersionService {

    private String scopeVariable;

    public String getBomId() {
        // Logic to retrieve BOM ID
        return "BOM_ID"; // Placeholder
    }

    public void setScopeVariable(String scopeVariable) {
        this.scopeVariable = scopeVariable;
    }

    public String getScopeVariable() {
        return scopeVariable;
    }

    public String getCurrentBomNumber() {
        // Logic to retrieve current BOM number
        return "CURRENT_BOM_NUMBER"; // Placeholder
    }

    @Transactional
    public Object getAttachments() {
        // Logic to fetch attachments
        return "Attachments"; // Placeholder
    }
}


yaml
# application.yml
spring:
  datasource:
    url: jdbc:oracle:thin:@localhost:1521:xe
    username: your_username
    password: your_password
    driver-class-name: oracle.jdbc.OracleDriver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true



// Main Application Class
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
