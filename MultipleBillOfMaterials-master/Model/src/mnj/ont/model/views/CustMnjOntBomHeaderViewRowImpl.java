
package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cust_mnj_ont_bom_header")
public class CustMnjOntBomHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bom_id")
    private Long bomId;

    @Column(name = "bom_number")
    private Long bomNumber;

    @Column(name = "bpo_no")
    private String bpoNo;

    @Column(name = "order_qty")
    private Long orderQty;

    @Column(name = "bom_date")
    @Temporal(TemporalType.DATE)
    private Date bomDate;

    @Column(name = "sale_order_id")
    private Long saleOrderId;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "bom_status")
    private String bomStatus;

    @Column(name = "revised_remarks")
    private String revisedRemarks;

    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "version_number")
    private Long versionNumber;

    @Column(name = "version_date")
    @Temporal(TemporalType.DATE)
    private Date versionDate;

    @Column(name = "link_oaf_id")
    private Long linkOafId;

    @Column(name = "effective_start_date")
    @Temporal(TemporalType.DATE)
    private Date effectiveStartDate;

    @Column(name = "effective_end_date")
    @Temporal(TemporalType.DATE)
    private Date effectiveEndDate;

    @Column(name = "last_update_date")
    @Temporal(TemporalType.DATE)
    private Date lastUpdateDate;

    @Column(name = "last_updated_by")
    private Long lastUpdatedBy;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "header_id")
    private Long headerId;

    @Column(name = "line_id")
    private Long lineId;

    @Column(name = "user_item_description")
    private String userItemDescription;

    @Column(name = "legacy_bom_id")
    private String legacyBomid;

    @Column(name = "org_id")
    private Long orgId;

    @Column(name = "post")
    private String post;

    @Column(name = "last_update_login")
    private Long lastUpdateLogin;

    @Column(name = "attribute1")
    private String attribute1;

    @Column(name = "attribute2")
    private String attribute2;

    @Column(name = "attribute3")
    private String attribute3;

    @Column(name = "attribute4")
    private String attribute4;

    @Column(name = "attribute5")
    private String attribute5;

    @Column(name = "attribute6")
    private String attribute6;

    @Column(name = "attribute7")
    private String attribute7;

    @Column(name = "attribute8")
    private String attribute8;

    @Column(name = "attribute9")
    private String attribute9;

    @Column(name = "attribute10")
    private String attribute10;

    @Column(name = "attribute11")
    private String attribute11;

    @Column(name = "attribute12")
    private String attribute12;

    @Column(name = "attribute13")
    private String attribute13;

    @Column(name = "attribute14")
    private String attribute14;

    @Column(name = "attribute15")
    private String attribute15;

    @Column(name = "sale_order_number")
    private Long saleOrderNumber;

    @Column(name = "buyer")
    private String buyer;

    @Column(name = "sale_order_number2")
    private Long saleOrderNumber2;

    @Column(name = "buyer_id")
    private Long buyerId;

    @Column(name = "bpo_no_c")
    private String bpoNoC;

    @Column(name = "brand_c")
    private String brandC;

    @Column(name = "end_user_desc_c")
    private String endUserDescC;

    @Column(name = "fit_c")
    private String fitC;

    @Column(name = "item_desc_c")
    private String itemDescC;

    @Column(name = "order_qty_c")
    private String orderQtyC;

    @Column(name = "season_c")
    private String seasonC;

    @Column(name = "style_name_c")
    private String styleNameC;

    @Column(name = "style_no_c")
    private String styleNoC;

    @Column(name = "attribute16")
    private String attribute16;

    @Column(name = "attribute17")
    private String attribute17;

    @Column(name = "attribute18")
    private String attribute18;

    @Column(name = "attribute19")
    private String attribute19;

    @Column(name = "attribute20")
    private String attribute20;

    @Column(name = "attribute21")
    private String attribute21;

    @Column(name = "attribute22")
    private String attribute22;

    @Column(name = "attribute23")
    private String attribute23;

    @Column(name = "attribute24")
    private String attribute24;

    @Column(name = "attribute25")
    private String attribute25;

    @Column(name = "attribute26")
    private String attribute26;

    @Column(name = "attribute27")
    private String attribute27;

    @Column(name = "attribute28")
    private String attribute28;

    @Column(name = "attribute29")
    private String attribute29;

    @Column(name = "attribute30")
    private String attribute30;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "unit_name")
    private String unitName;

    @Column(name = "shipment_unit")
    private String shipmentUnit;

    @Column(name = "attachemnt")
    private Long attachemnt;

    @Column(name = "tot_ord_qty")
    private Long totOrdQty;

    @Column(name = "order_type")
    private String orderType;

    @Column(name = "division")
    private String division;

    @Column(name = "style_name_new")
    private String styleNameNew;

    @Column(name = "current_style_no")
    private String currentStyleNo;

    @Column(name = "current_style_name")
    private String currentStyleName;

    // Add relationships if necessary
}
