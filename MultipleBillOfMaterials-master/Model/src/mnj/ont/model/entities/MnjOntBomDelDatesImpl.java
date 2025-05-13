
package mnj.ont.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "MNJ_ONT_BOM_DEL_DATES")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MnjOntBomDelDates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailId;

    private Long bomRmlineId;

    private java.util.Date deliveryDate;

    private Long qty;

    @ManyToOne
    @JoinColumn(name = "cust_mnj_ont_bom_rmline_lines_id")
    private CustMnjOntBomRmlineLines custMnjOntBomRmlineLines;

}



package mnj.ont.repository;

import mnj.ont.model.entities.MnjOntBomDelDates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MnjOntBomDelDatesRepository extends JpaRepository<MnjOntBomDelDates, Long> {
}



package mnj.ont.service;

import lombok.RequiredArgsConstructor;
import mnj.ont.model.entities.MnjOntBomDelDates;
import mnj.ont.repository.MnjOntBomDelDatesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MnjOntBomDelDatesService {

    private final MnjOntBomDelDatesRepository repository;

    @Transactional
    public MnjOntBomDelDates create(MnjOntBomDelDates delDate) {
        return repository.save(delDate);
    }

    public List<MnjOntBomDelDates> findAll() {
        return repository.findAll();
    }

    public MnjOntBomDelDates findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public MnjOntBomDelDates update(MnjOntBomDelDates delDate) {
        return repository.save(delDate);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}



package mnj.ont.controller;

import lombok.RequiredArgsConstructor;
import mnj.ont.model.entities.MnjOntBomDelDates;
import mnj.ont.service.MnjOntBomDelDatesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/del-dates")
@RequiredArgsConstructor
public class MnjOntBomDelDatesController {

    private final MnjOntBomDelDatesService service;

    @PostMapping
    public ResponseEntity<MnjOntBomDelDates> create(@RequestBody MnjOntBomDelDates delDate) {
        return ResponseEntity.ok(service.create(delDate));
    }

    @GetMapping
    public ResponseEntity<List<MnjOntBomDelDates>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MnjOntBomDelDates> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MnjOntBomDelDates> update(@PathVariable Long id, @RequestBody MnjOntBomDelDates delDate) {
        delDate.setDetailId(id);
        return ResponseEntity.ok(service.update(delDate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
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



package mnj.ont;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MnjOntApplication {

    public static void main(String[] args) {
        SpringApplication.run(MnjOntApplication.class, args);
    }
}
