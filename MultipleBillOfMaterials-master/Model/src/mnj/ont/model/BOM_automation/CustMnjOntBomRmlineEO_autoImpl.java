
package mnj.ont.model.BOM_automation;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CUST_MNJ_ONT_BOM_RMLINE")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustMnjOntBomRmline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bomRmlineId;

    private Long bomId;
    private String itemCategoryId;
    private String itemCode;
    private String measureUnitId;
    private Long noOfGarment;
    private Long usageMoUnit;
    private Long extraUsage;
    private Long rate;
    private String itemRefNo;
    private String productionArea;
    private String rmPlacement;
    private String rmInstruction;
    private Long preCostingLineno;
    private Date releaseDate;
    private Long versionNumber;
    private Date versionDate;
    private Long linkOafId;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private Date lastUpdateDate;
    private Long lastUpdatedBy;
    private Date creationDate;
    private Long createdBy;
    private Long inventoryItemId;
    private String itemPrefix;
    private Long processId;
    private String processDesc;
    private String rmlineType;
    private String printPageSide;
    private String legacyBomid;
    private String legacyBomtrid;
    private String legacyBomtrCid;
    private Long coneDesc;
    private Long coneValue;
    private Long noOfCones;
    private String threadUnit;
    private String requestType;
    private String pDesc;
    private String pName;
    private Long position;
    private Long cutP;
    private Long lastUpdateLogin;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;
    private String attribute8;
    private String attribute9;
    private String attribute10;
    private String attribute11;
    private String attribute12;
    private String attribute13;
    private String attribute14;
    private String attribute15;
    private Long vendorId;
    private Long bookedQty;
    private String flag;
    private String bookingUom;
    private Long poQty;
    private Date deliveryDate1;
    private Date deliveryDate2;
    private Date deliveryDate3;
    private Date deliveryDate4;
    private Date deliveryDate5;
    private Long qty1;
    private Long qty2;
    private Long qty3;
    private Long qty4;
    private Long qty5;
    private Long uomConvRate;
    private Long onhandQuantity;
    private Long allocateQty;
    private Long onhandQty1;
    private Long allocateQty1;
    private Long alocateIntrQty;
    private Long onhandCgl;
    private Long onhahndGfl;
    private Long alocateCgl;
    private Long alocateGfl;
    private Long alocateIntrCgl;
    private Long alocateInterGfl;
    private Long orgIdCal;
    private Long orgIdCgl;
    private Long orgIdGfl;
    private String approvalFlag;
    private String excesBuyReason;
    private Long pricePerUnit;
    private Long total;
    private Long perntg;
    private Long projPrQty;
    private Long lineId;
    private Long leftOverQty;
    private Long additionalQty;
    private Long actualPrcnt;
    private Long pendingPrcnt;
    private Long accumPrcnt;
    private Long transferQty;
    private String currency;
    private String purchaseType;
    private Long totalQuantity;
    private String remarks;

    @Transactional
    public void remove() {
        // Implement logic to check for child records and remove if no children exist
        // If children exist, throw an exception or return a message
    }

    @Transactional
    public void lock() {
        // Implement locking logic if necessary
    }

    @Transactional
    public void doDML(int operation) {
        // Implement custom DML logic if necessary
    }
}

@Repository
public interface CustMnjOntBomRmlineRepository extends JpaRepository<CustMnjOntBomRmline, Long> {
    // Custom query methods can be defined here
}

@Service
public class CustMnjOntBomRmlineService {

    private final CustMnjOntBomRmlineRepository repository;

    public CustMnjOntBomRmlineService(CustMnjOntBomRmlineRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CustMnjOntBomRmline create(CustMnjOntBomRmline entity) {
        // Set default values if necessary
        entity.setCurrency("USD");
        entity.setPurchaseType("Non-Generic");
        return repository.save(entity);
    }

    // Other service methods can be added here
}
