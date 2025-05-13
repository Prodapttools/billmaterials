
package mnj.ont.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CUST_MNJ_ONT_BOM_RMLINE")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustMnjOntBomRmlineLines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bomRmlineId;

    private Long bomId;
    private String itemCategoryId;
    private String itemCode;
    private String measureUnitId;
    private BigDecimal noOfGarment;
    private BigDecimal usageMoUnit;
    private BigDecimal extraUsage;
    private BigDecimal rate;
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
    private BigDecimal coneDesc;
    private BigDecimal coneValue;
    private BigDecimal noOfCones;
    private String threadUnit;
    private String requestType;
    private String pDesc;
    private String pName;
    private Long position;
    private BigDecimal cutP;
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
    private BigDecimal bookedQty;
    private String flag;
    private String bookingUom;
    private BigDecimal poQty;
    private Date deliveryDate1;
    private Date deliveryDate2;
    private Date deliveryDate3;
    private Date deliveryDate4;
    private Date deliveryDate5;
    private BigDecimal qty1;
    private BigDecimal qty2;
    private BigDecimal qty3;
    private BigDecimal qty4;
    private BigDecimal qty5;
    private BigDecimal uomConvRate;
    private BigDecimal onhandQuantity;
    private BigDecimal allocateQty;
    private BigDecimal onhandQty1;
    private BigDecimal allocateQty1;
    private BigDecimal alocateIntrQty;
    private BigDecimal onhandCgl;
    private BigDecimal onhahndGfl;
    private BigDecimal alocateCgl;
    private BigDecimal alocateGfl;
    private BigDecimal alocateIntrCgl;
    private BigDecimal alocateInterGfl;
    private Long orgIdCal;
    private Long orgIdCgl;
    private Long orgIdGfl;
    private String approvalFlag;
    private String excesBuyReason;
    private Long lineId;
    private BigDecimal pricePerUnit;
    private BigDecimal total;
    private BigDecimal perntg;
    private BigDecimal projPrQty;
    private BigDecimal leftOverQty;
    private BigDecimal additionalQty;
    private BigDecimal actualPrcnt;
    private BigDecimal pendingPrcnt;
    private BigDecimal accumPrcnt;
    private BigDecimal transferQty;
    private String currency;
    private String purchaseType;
    private String remarks;

    // Custom methods for business logic can be added here
}
