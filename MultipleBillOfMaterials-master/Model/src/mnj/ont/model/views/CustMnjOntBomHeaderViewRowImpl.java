
package com.company.module.model.views;

import com.company.module.model.entities.CustMnjOntBomHeaderImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Getter
@Setter
@Entity
@Table(name = "CUST_MNJ_ONT_BOM_HEADER")
public class CustMnjOntBomHeaderViewRowImpl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BOM_ID")
    private Long bomId;

    @Column(name = "BOM_NUMBER")
    private Long bomNumber;

    @Column(name = "BPO_NO")
    private String bpoNo;

    @Column(name = "ORDER_QTY")
    private Long orderqty;

    @Column(name = "BOM_DATE")
    @Temporal(TemporalType.DATE)
    private Date bomDate;

    @Column(name = "SALE_ORDER_ID")
    private Long saleorderId;

    @Column(name = "ITEM_CODE")
    private String itemCode;

    @Column(name = "BOM_STATUS")
    private String bomStatus;

    @Column(name = "REVISED_REMARKS")
    private String revisedRemarks;

    @Column(name = "RELEASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "VERSION_NUMBER")
    private Long versionNumber;

    @Column(name = "VERSION_DATE")
    @Temporal(TemporalType.DATE)
    private Date versionDate;

    @Column(name = "LINK_OAF_ID")
    private Long linkOafId;

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
    private Long lastUpdatedBy;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Column(name = "HEADER_ID")
    private Long headerId;

    @Column(name = "LINE_ID")
    private Long lineId;

    @Column(name = "USER_ITEM_DESCRIPTION")
    private String userItemDescription;

    @Column(name = "LEGACY_BOM_ID")
    private String legacyBomid;

    @Column(name = "ORG_ID")
    private Long orgId;

    @Column(name = "POST")
    private String post;

    @Column(name = "LAST_UPDATE_LOGIN")
    private Long lastUpdateLogin;

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

    @Column(name = "SALE_ORDER_NUMBER")
    private Long saleOrderNumber;

    @Column(name = "BUYER")
    private String buyer;

    @Column(name = "SALE_ORDER_NUMBER2")
    private Long saleOrderNumber2;

    @Column(name = "BUYER_ID")
    private Long buyerId;

    @Column(name = "BPO_NO_C")
    private String bpoNoC;

    @Column(name = "BRAND_C")
    private String brandC;

    @Column(name = "END_USER_DESC_C")
    private String endUserDescC;

    @Column(name = "FIT_C")
    private String fitC;

    @Column(name = "ITEM_DESC_C")
    private String itemDescC;

    @Column(name = "ORDER_QTY_C")
    private String orderQtyC;

    @Column(name = "SEASON_C")
    private String seasonC;

    @Column(name = "STYLE_NAME_C")
    private String styleNameC;

    @Column(name = "STYLE_NO_C")
    private String styleNoC;

    @Column(name = "ATTRIBUTE16")
    private String attribute16;

    @Column(name = "ATTRIBUTE17")
    private String attribute17;

    @Column(name = "ATTRIBUTE18")
    private String attribute18;

    @Column(name = "ATTRIBUTE19")
    private String attribute19;

    @Column(name = "ATTRIBUTE20")
    private String attribute20;

    @Column(name = "ATTRIBUTE21")
    private String attribute21;

    @Column(name = "ATTRIBUTE22")
    private String attribute22;

    @Column(name = "ATTRIBUTE23")
    private String attribute23;

    @Column(name = "ATTRIBUTE24")
    private String attribute24;

    @Column(name = "ATTRIBUTE25")
    private String attribute25;

    @Column(name = "ATTRIBUTE26")
    private String attribute26;

    @Column(name = "ATTRIBUTE27")
    private String attribute27;

    @Column(name = "ATTRIBUTE28")
    private String attribute28;

    @Column(name = "ATTRIBUTE29")
    private String attribute29;

    @Column(name = "ATTRIBUTE30")
    private String attribute30;

    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;

    @Column(name = "UNIT_NAME")
    private String unitName;

    @Column(name = "SHIPMENT_UNIT")
    private String shipmentUnit;

    @Column(name = "ATTACHEMNT")
    private Long attachemnt;

    @Column(name = "TOT_ORD_QTY")
    private Long totOrdQty;

    @Column(name = "ORDER_TYPE")
    private String orderType;

    @Column(name = "DIVISION")
    private String division;

    @Column(name = "STYLE_NAME_NEW")
    private String styleNameNew;

    @Column(name = "CURRENT_STYLE_NO")
    private String currentStyleNo;

    @Column(name = "CURRENT_STYLE_NAME")
    private String currentStyleName;

    // Additional relationships and methods can be added here
}
