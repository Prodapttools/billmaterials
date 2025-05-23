
package com.company.module.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CUST_MNJ_ONT_BOM_RMLINE_LINES")
@Getter
@Setter
@Component
public class CustMnjOntBomRmlineLinesImpl {

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
    @Temporal(TemporalType.DATE)
    private Date deliveryDate1;
    @Temporal(TemporalType.DATE)
    private Date deliveryDate2;
    @Temporal(TemporalType.DATE)
    private Date deliveryDate3;
    @Temporal(TemporalType.DATE)
    private Date deliveryDate4;
    @Temporal(TemporalType.DATE)
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
    private Long lineId;
    private Long pricePerUnit;
    private Long total;
    private Long perntg;
    private Long projPrQty;
    private Long leftOverQty;
    private Long additionalQty;
    private Long actualPrcnt;
    private Long pendingPrcnt;
    private Long accumPrcnt;
    private Long transferQty;
    private String currency;
    private String purchaseType;
    private String remarks;

    @PrePersist
    public void prePersist() {
        this.currency = "USD";
        this.purchaseType = "Non-Generic";
    }
}
