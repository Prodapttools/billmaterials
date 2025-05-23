
package com.company.module.model;

import com.company.module.entities.CustMnjOntBomOblineDetailsImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Entity
@Table(name = "CUST_MNJ_ONT_BOM_OBLINE_DETAILS")
public class CustMnjOntBomOblineDetailsViewRowImpl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BOM_ID")
    @Getter @Setter
    private Long bomId;

    @Column(name = "BOM_RMLINE_ID")
    @Getter @Setter
    private Long bomRmlineId;

    @Column(name = "BOM_OBLINE_ID")
    @Getter @Setter
    private Long bomOblineId;

    @Column(name = "SOLINE_ID")
    @Getter @Setter
    private Long solineId;

    @Column(name = "SO_OBNO")
    @Getter @Setter
    private String soObno;

    @Column(name = "INSEAM_ID")
    @Getter @Setter
    private String inseamId;

    @Column(name = "SIZE_ID")
    @Getter @Setter
    private String sizeId;

    @Column(name = "LINEREFNO")
    @Getter @Setter
    private String linerefno;

    @Column(name = "BARCODE")
    @Getter @Setter
    private String barcode;

    @Column(name = "RELEASE_DATE")
    @Getter @Setter
    private Date releaseDate;

    @Column(name = "VERSION_NUMBER")
    @Getter @Setter
    private Long versionNumber;

    @Column(name = "VERSION_DATE")
    @Getter @Setter
    private Date versionDate;

    @Column(name = "LINK_OAF_ID")
    @Getter @Setter
    private Long linkOafId;

    @Column(name = "EFFECTIVE_START_DATE")
    @Getter @Setter
    private Date effectiveStartDate;

    @Column(name = "EFFECTIVE_END_DATE")
    @Getter @Setter
    private Date effectiveEndDate;

    @Column(name = "LAST_UPDATE_DATE")
    @Getter @Setter
    private Date lastUpdateDate;

    @Column(name = "LAST_UPDATED_BY")
    @Getter @Setter
    private Long lastUpdatedBy;

    @Column(name = "CREATION_DATE")
    @Getter @Setter
    private Date creationDate;

    @Column(name = "CREATED_BY")
    @Getter @Setter
    private Long createdBy;

    @Column(name = "SIZE_QUANTITY")
    @Getter @Setter
    private Long sizeQuantity;

    @Column(name = "ITEM_CODE")
    @Getter @Setter
    private String itemCode;

    @Column(name = "LINE_NO")
    @Getter @Setter
    private Long lineNo;

    @Column(name = "INVENTORY_ITEM_ID")
    @Getter @Setter
    private Long inventoryItemId;

    @Column(name = "CONSUMPTION")
    @Getter @Setter
    private Long consumption;

    @Column(name = "WITH_EXTRA")
    @Getter @Setter
    private Long withExtra;

    @Column(name = "LEGACY_BOMTRID")
    @Getter @Setter
    private String legacyBomtrid;

    @Column(name = "LEGACY_BOMTR_CID")
    @Getter @Setter
    private String legacyBomtrCid;

    @Column(name = "LEGACY_ID")
    @Getter @Setter
    private String legacyId;

    @Column(name = "CUT_P")
    @Getter @Setter
    private Long cutP;

    @Column(name = "LAST_UPDATE_LOGIN")
    @Getter @Setter
    private Long lastUpdateLogin;

    @Column(name = "ATTRIBUTE1")
    @Getter @Setter
    private String attribute1;

    @Column(name = "ATTRIBUTE2")
    @Getter @Setter
    private String attribute2;

    @Column(name = "ATTRIBUTE3")
    @Getter @Setter
    private String attribute3;

    @Column(name = "ATTRIBUTE4")
    @Getter @Setter
    private String attribute4;

    @Column(name = "ATTRIBUTE5")
    @Getter @Setter
    private String attribute5;

    @Column(name = "ATTRIBUTE6")
    @Getter @Setter
    private String attribute6;

    @Column(name = "ATTRIBUTE7")
    @Getter @Setter
    private String attribute7;

    @Column(name = "ATTRIBUTE8")
    @Getter @Setter
    private String attribute8;

    @Column(name = "ATTRIBUTE9")
    @Getter @Setter
    private String attribute9;

    @Column(name = "ATTRIBUTE10")
    @Getter @Setter
    private String attribute10;

    @Column(name = "ATTRIBUTE11")
    @Getter @Setter
    private String attribute11;

    @Column(name = "ATTRIBUTE12")
    @Getter @Setter
    private String attribute12;

    @Column(name = "ATTRIBUTE13")
    @Getter @Setter
    private String attribute13;

    @Column(name = "ATTRIBUTE14")
    @Getter @Setter
    private String attribute14;

    @Column(name = "ATTRIBUTE15")
    @Getter @Setter
    private String attribute15;

    @Column(name = "CONS_EXTRA")
    @Getter @Setter
    private Long consExtra;

    @Column(name = "MEMO_QTY")
    @Getter @Setter
    private String memoQty;

    @Column(name = "ADDITIONAL")
    @Getter @Setter
    private String additional;

    @Column(name = "INSEAM")
    @Getter @Setter
    private String inseam;

    @Column(name = "DCPO_NO")
    @Getter @Setter
    private String dcpoNo;

    @Column(name = "COLOR")
    @Getter @Setter
    private String color;

    @Column(name = "SIZE_VAL")
    @Getter @Setter
    private String sizeVal;

    @Column(name = "PO_QTY")
    @Getter @Setter
    private Long poQty;

    @Column(name = "TOTAL_QTY")
    @Getter @Setter
    private Long totalQty;

    // Additional methods for calculated fields can be added here
}
