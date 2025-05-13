
package mnj.ont.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "MNJ_BOM_BPO_LINES_ALL")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MnjBomBpoLinesAll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineId;

    private Long bomId;
    private String bpoNo;
    private Long saleOrderId;
    private String sealeNo;
    private String userItemDesc;
    private String endUserDesc;
    private Long orderQty;
    private String fit;
    private String brand;
    private String styleNo;
    private String season;

    @ManyToOne
    @JoinColumn(name = "CUST_MNJ_ONT_BOM_HEADER_ID")
    private CustMnjOntBomHeader custMnjOntBomHeader;

}



package mnj.ont.repository;

import mnj.ont.model.entities.MnjBomBpoLinesAll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MnjBomBpoLinesAllRepository extends JpaRepository<MnjBomBpoLinesAll, Long> {
}



package mnj.ont.service;

import lombok.RequiredArgsConstructor;
import mnj.ont.model.entities.MnjBomBpoLinesAll;
import mnj.ont.repository.MnjBomBpoLinesAllRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MnjBomBpoLinesAllService {

    private final MnjBomBpoLinesAllRepository repository;

    @Transactional
    public MnjBomBpoLinesAll create(MnjBomBpoLinesAll line) {
        return repository.save(line);
    }

    public List<MnjBomBpoLinesAll> findAll() {
        return repository.findAll();
    }

    public MnjBomBpoLinesAll findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}



package mnj.ont.controller;

import lombok.RequiredArgsConstructor;
import mnj.ont.model.entities.MnjBomBpoLinesAll;
import mnj.ont.service.MnjBomBpoLinesAllService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bpo-lines")
@RequiredArgsConstructor
public class MnjBomBpoLinesAllController {

    private final MnjBomBpoLinesAllService service;

    @PostMapping
    public ResponseEntity<MnjBomBpoLinesAll> create(@RequestBody MnjBomBpoLinesAll line) {
        return ResponseEntity.ok(service.create(line));
    }

    @GetMapping
    public ResponseEntity<List<MnjBomBpoLinesAll>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MnjBomBpoLinesAll> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
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
