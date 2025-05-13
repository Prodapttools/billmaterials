
package mnj.ont.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "mnj_ont_bom_del_dates")
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

    private Integer qty;

    @ManyToOne
    @JoinColumn(name = "cust_mnj_ont_bom_rmline_lines_id")
    private CustMnjOntBomRmlineLines custMnjOntBomRmlineLines;

    // Additional methods can be added here if needed
}



package mnj.ont.repository;

import mnj.ont.model.entities.MnjOntBomDelDates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MnjOntBomDelDatesRepository extends JpaRepository<MnjOntBomDelDates, Long> {
    // Custom query methods can be defined here
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
    public MnjOntBomDelDates createMnjOntBomDelDates(MnjOntBomDelDates mnjOntBomDelDates) {
        return repository.save(mnjOntBomDelDates);
    }

    public List<MnjOntBomDelDates> getAllMnjOntBomDelDates() {
        return repository.findAll();
    }

    // Additional service methods can be added here
}



package mnj.ont.controller;

import lombok.RequiredArgsConstructor;
import mnj.ont.model.entities.MnjOntBomDelDates;
import mnj.ont.service.MnjOntBomDelDatesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mnj-ont-bom-del-dates")
@RequiredArgsConstructor
public class MnjOntBomDelDatesController {

    private final MnjOntBomDelDatesService service;

    @PostMapping
    public ResponseEntity<MnjOntBomDelDates> create(@RequestBody MnjOntBomDelDates mnjOntBomDelDates) {
        MnjOntBomDelDates created = service.createMnjOntBomDelDates(mnjOntBomDelDates);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<MnjOntBomDelDates>> getAll() {
        List<MnjOntBomDelDates> delDates = service.getAllMnjOntBomDelDates();
        return ResponseEntity.ok(delDates);
    }

    // Additional endpoints can be added here
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
public class MnjOntApplication {

    public static void main(String[] args) {
        SpringApplication.run(MnjOntApplication.class, args);
    }
}
