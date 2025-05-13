
package mnj.ont.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "mnj_bom_size_det")
public class MnjBomSizeDet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detId;

    private Long bomRmlineId;
    private String sizeVal;
    private Long sizeWiseOrderQty;
    private Long sizeWiseBomReqQty;
    private Long bookingPercent;
    private Long sizeWiseProjQty;
    private Long addDeduct;
    private Long actualQty;
    private String flag;

    @ManyToOne
    @JoinColumn(name = "cust_mnj_ont_bom_rmline_lines_id")
    private CustMnjOntBomRmlineLines custMnjOntBomRmlineLines;

    // Additional methods can be added here if needed
}



package mnj.ont.repository;

import mnj.ont.model.entities.MnjBomSizeDet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MnjBomSizeDetRepository extends JpaRepository<MnjBomSizeDet, Long> {
    // Custom query methods can be defined here
}



package mnj.ont.service;

import lombok.RequiredArgsConstructor;
import mnj.ont.model.entities.MnjBomSizeDet;
import mnj.ont.repository.MnjBomSizeDetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MnjBomSizeDetService {

    private final MnjBomSizeDetRepository repository;

    @Transactional
    public MnjBomSizeDet createMnjBomSizeDet(MnjBomSizeDet mnjBomSizeDet) {
        return repository.save(mnjBomSizeDet);
    }

    public List<MnjBomSizeDet> getAllMnjBomSizeDets() {
        return repository.findAll();
    }

    public MnjBomSizeDet getMnjBomSizeDetById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public MnjBomSizeDet updateMnjBomSizeDet(Long id, MnjBomSizeDet mnjBomSizeDet) {
        mnjBomSizeDet.setDetId(id);
        return repository.save(mnjBomSizeDet);
    }

    @Transactional
    public void deleteMnjBomSizeDet(Long id) {
        repository.deleteById(id);
    }
}



package mnj.ont.controller;

import lombok.RequiredArgsConstructor;
import mnj.ont.model.entities.MnjBomSizeDet;
import mnj.ont.service.MnjBomSizeDetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mnj-bom-size-det")
@RequiredArgsConstructor
public class MnjBomSizeDetController {

    private final MnjBomSizeDetService service;

    @PostMapping
    public ResponseEntity<MnjBomSizeDet> createMnjBomSizeDet(@RequestBody MnjBomSizeDet mnjBomSizeDet) {
        return ResponseEntity.ok(service.createMnjBomSizeDet(mnjBomSizeDet));
    }

    @GetMapping
    public ResponseEntity<List<MnjBomSizeDet>> getAllMnjBomSizeDets() {
        return ResponseEntity.ok(service.getAllMnjBomSizeDets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MnjBomSizeDet> getMnjBomSizeDetById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getMnjBomSizeDetById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MnjBomSizeDet> updateMnjBomSizeDet(@PathVariable Long id, @RequestBody MnjBomSizeDet mnjBomSizeDet) {
        return ResponseEntity.ok(service.updateMnjBomSizeDet(id, mnjBomSizeDet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMnjBomSizeDet(@PathVariable Long id) {
        service.deleteMnjBomSizeDet(id);
        return ResponseEntity.noContent().build();
    }
}


properties
# application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true



package mnj.ont;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MnjApplication {
    public static void main(String[] args) {
        SpringApplication.run(MnjApplication.class, args);
    }
}
