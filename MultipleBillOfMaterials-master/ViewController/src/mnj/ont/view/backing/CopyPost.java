
package com.company.module.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Slf4j
@RestController
@RequestMapping("/copyPost")
public class CopyPost {

    private final QueryTableService queryTableService;

    @Autowired
    public CopyPost(QueryTableService queryTableService) {
        this.queryTableService = queryTableService;
    }

    @PostMapping("/copy")
    @Transactional
    public void copy() {
        log.info("Executing copy operation");
        queryTableService.executeOperation("HeaderActions", "C");
    }

    @PostMapping("/post")
    @Transactional
    public void post() {
        log.info("Executing post operation");
        queryTableService.executeOperation("HeaderActions", "V");
    }
}



package com.company.module.service;

import org.springframework.stereotype.Service;

@Service
public class QueryTableService {

    public void executeOperation(String operation, String type) {
        // Logic to execute the operation and update the query table
        // This is a placeholder for the actual implementation
    }
}
