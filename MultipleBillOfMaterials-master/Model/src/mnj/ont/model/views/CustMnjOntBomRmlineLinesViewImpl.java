
package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table(name = "bom_rmline_lines")
@EntityListeners(AuditingEntityListener.class)
public class BomRmlineLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add other fields here

    // Getters and Setters
}

@Repository
public interface BomRmlineLineRepository extends JpaRepository<BomRmlineLine, Long> {
}

@Service
public class BomRmlineLineService {

    private final BomRmlineLineRepository repository;

    public BomRmlineLineService(BomRmlineLineRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public BomRmlineLine insertRow(BomRmlineLine line) {
        return repository.save(line);
    }
}

@RestController
@RequestMapping("/api/bom-rmline-lines")
public class BomRmlineLineController {

    private final BomRmlineLineService service;

    public BomRmlineLineController(BomRmlineLineService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BomRmlineLine> createLine(@RequestBody BomRmlineLine line) {
        BomRmlineLine createdLine = service.insertRow(line);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLine);
    }
}
