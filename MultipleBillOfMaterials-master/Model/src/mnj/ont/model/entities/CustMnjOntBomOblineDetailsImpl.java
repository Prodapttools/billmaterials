
package mnj.ont.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CUST_MNJ_ONT_BOM_OBLINE_DETAILS")
@Data
@NoArgsConstructor
public class CustMnjOntBomOblineDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOM_OBLINE_ID")
    private Long bomOblineId;

    @Column(name = "BOM_ID")
    private BigDecimal bomId;

    @Column(name = "BOM_RMLINE_ID")
    private BigDecimal bomRmlineId;

    @Column(name = "SOLINE_ID")
    private BigDecimal solineId;

    @Column(name = "SO_OBNO")
    private String soObno;

    @Column(name = "INSEAM_ID")
    private String inseamId;

    @Column(name = "SIZE_ID")
    private String sizeId;

    @Column(name = "LINEREFNO")
    private String linerefno;

    @Column(name = "BARCODE")
    private String barcode;

    @Column(name = "RELEASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "VERSION_NUMBER")
    private BigDecimal versionNumber;

    @Column(name = "VERSION_DATE")
    @Temporal(TemporalType.DATE)
    private Date versionDate;

    @Column(name = "LINK_OAF_ID")
    private BigDecimal linkOafId;

    @Column(name = "EFFECTIVE_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date effectiveStartDate;

    @Column(name = "EFFECTIVE_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date effectiveEndDate;

    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastUpdateDate;

    @Column(name = "LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "CREATED_BY")
    private BigDecimal createdBy;

    @Column(name = "SIZE_QUANTITY")
    private BigDecimal sizeQuantity;

    @Column(name = "ITEM_CODE")
    private String itemCode;

    @Column(name = "LINE_NO")
    private BigDecimal lineNo;

    @Column(name = "INVENTORY_ITEM_ID")
    private BigDecimal inventoryItemId;

    @Column(name = "CONSUMPTION")
    private BigDecimal consumption;

    @Column(name = "WITH_EXTRA")
    private BigDecimal withExtra;

    @Column(name = "LEGACY_BOMTRID")
    private String legacyBomtrid;

    @Column(name = "LEGACY_BOMTRCID")
    private String legacyBomtrCid;

    @Column(name = "LEGACY_ID")
    private String legacyId;

    @Column(name = "CUT_P")
    private BigDecimal cutP;

    @Column(name = "LAST_UPDATE_LOGIN")
    private BigDecimal lastUpdateLogin;

    @Column(name = "ATTRIBUTE1")
    private String attribute1;

    @Column(name = "ATTRIBUTE2")
    private String attribute2;

    @Column(name = "ATTRIBUTE3")
    private String attribute3;

    @Column(name = "ATTRIBUTE4")
    private String attribute4;

    @Column(name = "ATTRIBUTE5")
    private String attribute5;

    @Column(name = "ATTRIBUTE6")
    private String attribute6;

    @Column(name = "ATTRIBUTE7")
    private String attribute7;

    @Column(name = "ATTRIBUTE8")
    private String attribute8;

    @Column(name = "ATTRIBUTE9")
    private String attribute9;

    @Column(name = "ATTRIBUTE10")
    private String attribute10;

    @Column(name = "ATTRIBUTE11")
    private String attribute11;

    @Column(name = "ATTRIBUTE12")
    private String attribute12;

    @Column(name = "ATTRIBUTE13")
    private String attribute13;

    @Column(name = "ATTRIBUTE14")
    private String attribute14;

    @Column(name = "ATTRIBUTE15")
    private String attribute15;

    @Column(name = "DCPONO")
    private String dcpoNo;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "SIZE_VAL")
    private String sizeVal;

    @Column(name = "PO_QTY")
    private BigDecimal poQty;

    // Relationships can be defined here if needed
}
