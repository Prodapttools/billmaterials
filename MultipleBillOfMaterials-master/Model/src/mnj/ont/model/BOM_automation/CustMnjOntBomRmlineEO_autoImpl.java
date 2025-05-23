
package mnj.ont.model.BOM_automation;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Entity
@Table(name = "CUST_MNJ_ONT_BOM_RMLINE")
public class CustMnjOntBomRmlineEO_autoImpl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOM_RMLINE_ID")
    private Long bomRmlineId;

    @Column(name = "BOM_ID")
    private Long bomId;

    @Column(name = "ITEM_CATEGORY_ID")
    private String itemCategoryId;

    @Column(name = "ITEM_CODE")
    private String itemCode;

    @Column(name = "MEASURE_UNIT_ID")
    private String measureUnitId;

    @Column(name = "NO_OF_GARMENT")
    private Long noOfGarment;

    @Column(name = "USAGE_MO_UNIT")
    private Long usageMoUnit;

    @Column(name = "EXTRA_USAGE")
    private Long extraUsage;

    @Column(name = "RATE")
    private Long rate;

    @Column(name = "ITEM_REF_NO")
    private String itemRefNo;

    @Column(name = "PRODUCTION_AREA")
    private String productionArea;

    @Column(name = "RM_PLACEMENT")
    private String rmPlacement;

    @Column(name = "RM_INSTRUCTION")
    private String rmInstruction;

    @Column(name = "PRE_COSTING_LINE_NO")
    private Long preCostingLineno;

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

    @Column(name = "INVENTORY_ITEM_ID")
    private Long inventoryItemId;

    @Column(name = "ITEM_PREFIX")
    private String itemPrefix;

    @Column(name = "PROCESS_ID")
    private Long processId;

    @Column(name = "PROCESS_DESC")
    private String processDesc;

    @Column(name = "RM_LINE_TYPE")
    private String rmlineType;

    @Column(name = "PRINT_PAGE_SIDE")
    private String printPageSide;

    @Column(name = "LEGACY_BOM_ID")
    private String legacyBomid;

    @Column(name = "LEGACY_BOM_TR_ID")
    private String legacyBomtrid;

    @Column(name = "LEGACY_BOM_TR_CID")
    private String legacyBomtrCid;

    @Column(name = "CONE_DESC")
    private Long coneDesc;

    @Column(name = "CONE_VALUE")
    private Long coneValue;

    @Column(name = "NO_OF_CONES")
    private Long noOfCones;

    @Column(name = "THREAD_UNIT")
    private String threadUnit;

    @Column(name = "REQUEST_TYPE")
    private String requestType;

    @Column(name = "P_DESC")
    private String pDesc;

    @Column(name = "P_NAME")
    private String pName;

    @Column(name = "POSITION")
    private Long position;

    @Column(name = "CUT_P")
    private Long cutP;

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

    @Column(name = "VENDOR_ID")
    private Long vendorId;

    @Column(name = "BOOKED_QTY")
    private Long bookedQty;

    @Column(name = "FLAG")
    private String flag;

    @Column(name = "BOOKING_UOM")
    private String bookingUom;

    @Column(name = "PO_QTY")
    private Long poQty;

    @Column(name = "DELIVERY_DATE1")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate1;

    @Column(name = "DELIVERY_DATE2")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate2;

    @Column(name = "DELIVERY_DATE3")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate3;

    @Column(name = "DELIVERY_DATE4")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate4;

    @Column(name = "DELIVERY_DATE5")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate5;

    @Column(name = "QTY1")
    private Long qty1;

    @Column(name = "QTY2")
    private Long qty2;

    @Column(name = "QTY3")
    private Long qty3;

    @Column(name = "QTY4")
    private Long qty4;

    @Column(name = "QTY5")
    private Long qty5;

    @Column(name = "UOM_CONV_RATE")
    private Long uomConvRate;

    @Column(name = "ONHAND_QUANTITY")
    private Long onhandQuantity;

    @Column(name = "ALLOCATE_QTY")
    private Long allocateQty;

    @Column(name = "ONHAND_QTY1")
    private Long onhandQty1;

    @Column(name = "ALLOCATE_QTY1")
    private Long allocateQty1;

    @Column(name = "ALOCATE_INTR_QTY")
    private Long alocateIntrQty;

    @Column(name = "ONHAND_CGL")
    private Long onhandCgl;

    @Column(name = "ONHAHND_GFL")
    private Long onhahndGfl;

    @Column(name = "ALOCATE_CGL")
    private Long alocateCgl;

    @Column(name = "ALOCATE_GFL")
    private Long alocateGfl;

    @Column(name = "ALOCATE_INTR_CGL")
    private Long alocateIntrCgl;

    @Column(name = "ALOCATE_INTER_GFL")
    private Long alocateInterGfl;

    @Column(name = "ORG_ID_CAL")
    private Long orgIdCal;

    @Column(name = "ORG_ID_CGL")
    private Long orgIdCgl;

    @Column(name = "ORG_ID_GFL")
    private Long orgIdGfl;

    @Column(name = "APPROVAL_FLAG")
    private String approvalFlag;

    @Column(name = "EXCES_BUY_REASON")
    private String excesBuyReason;

    @Column(name = "PRICE_PER_UNIT")
    private Long pricePerUnit;

    @Column(name = "TOTAL")
    private Long total;

    @Column(name = "PERNTG")
    private Long perntg;

    @Column(name = "PROJ_PR_QTY")
    private Long projPrQty;

    @Column(name = "LINE_ID")
    private Long lineId;

    @Column(name = "LEFT_OVER_QTY")
    private Long leftOverQty;

    @Column(name = "ADDITIONAL_QTY")
    private Long additionalQty;

    @Column(name = "ACTUAL_PRCNT")
    private Long actualPrcnt;

    @Column(name = "PENDING_PRCNT")
    private Long pendingPrcnt;

    @Column(name = "ACCUM_PRCNT")
    private Long accumPrcnt;

    @Column(name = "TRANSFER_QTY")
    private Long transferQty;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "PURCHASE_TYPE")
    private String purchaseType;

    @Column(name = "TOTAL_QUANTITY")
    private Long totalQuantity;

    @Column(name = "REMARKS")
    private String remarks;

    public CustMnjOntBomRmlineEO_autoImpl() {
    }

    // Getters and Setters
    // ...
}
