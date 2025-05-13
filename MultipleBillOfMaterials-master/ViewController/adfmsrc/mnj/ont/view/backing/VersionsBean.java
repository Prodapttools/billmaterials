
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/versions")
public class VersionsController {

    @Autowired
    private VersionsService versionsService;

    @PostMapping("/action")
    public void versionsActionListener(@RequestParam("hederno2") String hederno2) {
        System.out.println("value in bean --->" + hederno2);
        versionsService.setScopeVariable(hederno2);
        System.out.println("get value-->" + versionsService.getScopeVariable());
    }

    @GetMapping("/attachment")
    public void callAttachment(HttpSession session) throws IOException {
        String doc = versionsService.getCurrentBomNumber();
        String newPage = "http://192.168.200.115:7003/FileUploading-ViewController-context-root/faces/view1?doc=CD_Invoice_No&docNo=" + doc;
        // Logic to open a new window or redirect can be handled in the frontend
        // For example, you can return a URL to the frontend to handle it
    }

    @PostMapping("/setSession")
    public void goPrAction(@RequestParam("hederno2") String hederno2, HttpSession session) {
        session.setAttribute("BOMNO", hederno2);
    }

    @GetMapping("/fetchAttachments")
    public Object attachFetchListener() {
        return versionsService.getAttachments();
    }
}



package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VersionsService {

    private String scopeVariable;

    public void setScopeVariable(String scopeVariable) {
        this.scopeVariable = scopeVariable;
    }

    public String getScopeVariable() {
        return scopeVariable;
    }

    @Transactional(readOnly = true)
    public String getCurrentBomNumber() {
        // Logic to fetch the current BOM number from the database
        // This would typically involve a repository call
        return "dummyBomNumber"; // Replace with actual logic
    }

    @Transactional
    public Object getAttachments() {
        // Logic to fetch attachments
        return "dummyAttachments"; // Replace with actual logic
    }
}



// application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true



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
