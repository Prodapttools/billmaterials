
package com.example.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "popupline")
public class Popupline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inventory_item_id")
    private Long inventoryItemId;

    @Column(name = "header_id")
    private Long headerId;

    @Column(name = "ob_ref")
    private String obRef;

    @Column(name = "ordered_item")
    private String orderedItem;

    @Column(name = "description")
    private String description;

    @Column(name = "dcpo_no")
    private String dcpoNo;

    @Column(name = "inseam_qty")
    private Long inseamQty;

    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @Column(name = "delivery_term")
    private String deliveryTerm;

    @Column(name = "ship_mode")
    private String shipMode;

    @Column(name = "country")
    private String country;

    @Column(name = "inseam_size_concat")
    private String inseamSizeConcat;

    @Column(name = "size_qty")
    private Long sizeQty;

    @Column(name = "color")
    private String color;

    @Column(name = "bom_id")
    private Long bomId;

    @Column(name = "inseem")
    private String inseem;

    @Column(name = "size_id")
    private Long sizeId;

    @Column(name = "size_value")
    private Long sizeValue;

    @Column(name = "multiselect")
    private String multiselect;
}



package com.example.repository;

import com.example.model.Popupline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopuplineRepository extends JpaRepository<Popupline, Long> {
}



package com.example.service;

import com.example.model.Popupline;
import com.example.repository.PopuplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PopuplineService {

    @Autowired
    private PopuplineRepository popuplineRepository;

    public List<Popupline> findAll() {
        return popuplineRepository.findAll();
    }

    public Popupline findById(Long id) {
        return popuplineRepository.findById(id).orElse(null);
    }

    public Popupline save(Popupline popupline) {
        return popuplineRepository.save(popupline);
    }

    public void deleteById(Long id) {
        popuplineRepository.deleteById(id);
    }
}



package com.example.controller;

import com.example.model.Popupline;
import com.example.service.PopuplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/popupline")
public class PopuplineController {

    @Autowired
    private PopuplineService popuplineService;

    @GetMapping
    public List<Popupline> getAllPopulines() {
        return popuplineService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Popupline> getPopuplineById(@PathVariable Long id) {
        Popupline popupline = popuplineService.findById(id);
        return popupline != null ? ResponseEntity.ok(popupline) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Popupline createPopupline(@RequestBody Popupline popupline) {
        return popuplineService.save(popupline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Popupline> updatePopupline(@PathVariable Long id, @RequestBody Popupline popuplineDetails) {
        Popupline popupline = popuplineService.findById(id);
        if (popupline == null) {
            return ResponseEntity.notFound().build();
        }
        popupline.setInventoryItemId(popuplineDetails.getInventoryItemId());
        popupline.setHeaderId(popuplineDetails.getHeaderId());
        popupline.setObRef(popuplineDetails.getObRef());
        popupline.setOrderedItem(popuplineDetails.getOrderedItem());
        popupline.setDescription(popuplineDetails.getDescription());
        popupline.setDcpoNo(popuplineDetails.getDcpoNo());
        popupline.setInseamQty(popuplineDetails.getInseamQty());
        popupline.setDeliveryDate(popuplineDetails.getDeliveryDate());
        popupline.setDeliveryTerm(popuplineDetails.getDeliveryTerm());
        popupline.setShipMode(popuplineDetails.getShipMode());
        popupline.setCountry(popuplineDetails.getCountry());
        popupline.setInseamSizeConcat(popuplineDetails.getInseamSizeConcat());
        popupline.setSizeQty(popuplineDetails.getSizeQty());
        popupline.setColor(popuplineDetails.getColor());
        popupline.setBomId(popuplineDetails.getBomId());
        popupline.setInseem(popuplineDetails.getInseem());
        popupline.setSizeId(popuplineDetails.getSizeId());
        popupline.setSizeValue(popuplineDetails.getSizeValue());
        popupline.setMultiselect(popuplineDetails.getMultiselect());
        return ResponseEntity.ok(popuplineService.save(popupline));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePopupline(@PathVariable Long id) {
        popuplineService.deleteById(id);
        return ResponseEntity.noContent().build();
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
