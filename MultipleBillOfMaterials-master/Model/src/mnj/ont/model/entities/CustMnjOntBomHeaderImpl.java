
package mnj.ont.model.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CUST_MNJ_ONT_BOM_HEADER")
@Service
public class CustMnjOntBomHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bomId;

    private Long bomNumber;

    @Temporal(TemporalType.DATE)
    private Date bomDate;

    private Long saleorderId;
    private String itemCode;
    private String bomStatus;
    private String revisedRemarks;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    private Long versionNumber;

    @Temporal(TemporalType.DATE)
    private Date versionDate;

    private Long linkOafId;

    @Temporal(TemporalType.DATE)
    private Date effectiveStartDate;

    @Temporal(TemporalType.DATE)
    private Date effectiveEndDate;

    @Temporal(TemporalType.DATE)
    private Date lastUpdateDate;

    private Long lastUpdatedBy;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    private Long createdBy;

    private Long headerId;
    private Long lineId;
    private String userItemDescription;
    private String legacyBomid;
    private Long orgId;
    private String post;
    private Long lastUpdateLogin;

    // Additional attributes
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
    private Long buyerId;
    private String bpoNoC;
    private String seasonC;
    private String styleNameC;
    private String styleNoC;
    private String itemDescC;
    private String brandC;
    private String fitC;
    private String orderQtyC;
    private String endUserDescC;
    private String attribute16;
    private String attribute17;
    private String attribute18;
    private String attribute19;
    private String attribute20;
    private String attribute21;
    private String attribute22;
    private String attribute23;
    private String attribute24;
    private String attribute25;
    private String attribute26;
    private String attribute27;
    private String attribute28;
    private String attribute29;
    private String attribute30;
    private String errorMessage;
    private String orderType;
    private String division;
    private String styleNameNew;

    // Getters and Setters

    // Validation logic
    @PrePersist
    @PreUpdate
    public void validateEntity() {
        if (styleNoC == null && styleNameNew == null) {
            throw new IllegalArgumentException("You can't leave Style Name and Style No both Blank, please fill any one.");
        }
    }

    @Transactional
    public void remove() {
        // Implement removal logic with child record check
    }

    @Transactional
    public void doDML(int operation) {
        String user = "currentUser"; // Replace with actual user retrieval logic

        if (operation == 1) { // DML_INSERT
            setBomNumber(getSrNoString());
            setCreationDate(new Date());
            setCreatedBy(Long.valueOf(user));
        } else if (operation == 2) { // DML_UPDATE
            setLastUpdateDate(new Date());
            setLastUpdatedBy(Long.valueOf(user));
        }
    }

    public int getSrNoString() {
        // Implement logic to retrieve sequence number
        return 0; // Placeholder
    }
}
