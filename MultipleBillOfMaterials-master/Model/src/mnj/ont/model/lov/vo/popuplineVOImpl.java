
package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Entity class representing the data model
@Entity
public class Popupline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add other fields and their mappings here

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Other getters and setters
}

// Repository interface for data access
public interface PopuplineRepository extends JpaRepository<Popupline, Long>, JpaSpecificationExecutor<Popupline> {
}

// Service class for business logic
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PopuplineService {

    private final PopuplineRepository popuplineRepository;

    @Autowired
    public PopuplineService(PopuplineRepository popuplineRepository) {
        this.popuplineRepository = popuplineRepository;
    }

    public List<Popupline> findAll() {
        return popuplineRepository.findAll();
    }

    // Other service methods
}

// REST Controller for handling HTTP requests
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/popuplines")
public class PopuplineController {

    private final PopuplineService popuplineService;

    @Autowired
    public PopuplineController(PopuplineService popuplineService) {
        this.popuplineService = popuplineService;
    }

    @GetMapping
    public List<Popupline> getAllPopulines() {
        return popuplineService.findAll();
    }

    // Other endpoints
}
