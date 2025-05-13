
package mnj.ont.model.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    public Long getBomId() {
        return bomId;
    }

    public void setBomId(Long bomId) {
        this.bomId = bomId;
    }

    public Long getBomNumber() {
        return bomNumber;
    }

    public void setBomNumber(Long bomNumber) {
        this.bomNumber = bomNumber;
    }

    public Date getBomDate() {
        return bomDate;
    }

    public void setBomDate(Date bomDate) {
        this.bomDate = bomDate;
    }

    public Long getSaleorderId() {
        return saleorderId;
    }

    public void setSaleorderId(Long saleorderId) {
        this.saleorderId = saleorderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getBomStatus() {
        return bomStatus;
    }

    public void setBomStatus(String bomStatus) {
        this.bomStatus = bomStatus;
    }

    public String getRevisedRemarks() {
        return revisedRemarks;
    }

    public void setRevisedRemarks(String revisedRemarks) {
        this.revisedRemarks = revisedRemarks;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Long versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Date getVersionDate() {
        return versionDate;
    }

    public void setVersionDate(Date versionDate) {
        this.versionDate = versionDate;
    }

    public Long getLinkOafId() {
        return linkOafId;
    }

    public void setLinkOafId(Long linkOafId) {
        this.linkOafId = linkOafId;
    }

    public Date getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(Date effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    public Date getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public String getUserItemDescription() {
        return userItemDescription;
    }

    public void setUserItemDescription(String userItemDescription) {
        this.userItemDescription = userItemDescription;
    }

    public String getLegacyBomid() {
        return legacyBomid;
    }

    public void setLegacyBomid(String legacyBomid) {
        this.legacyBomid = legacyBomid;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Long getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(Long lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public String getAttribute11() {
        return attribute11;
    }

    public void setAttribute11(String attribute11) {
        this.attribute11 = attribute11;
    }

    public String getAttribute12() {
        return attribute12;
    }

    public void setAttribute12(String attribute12) {
        this.attribute12 = attribute12;
    }

    public String getAttribute13() {
        return attribute13;
    }

    public void setAttribute13(String attribute13) {
        this.attribute13 = attribute13;
    }

    public String getAttribute14() {
        return attribute14;
    }

    public void setAttribute14(String attribute14) {
        this.attribute14 = attribute14;
    }

    public String getAttribute15() {
        return attribute15;
    }

    public void setAttribute15(String attribute15) {
        this.attribute15 = attribute15;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBpoNoC() {
        return bpoNoC;
    }

    public void setBpoNoC(String bpoNoC) {
        this.bpoNoC = bpoNoC;
    }

    public String getSeasonC() {
        return seasonC;
    }

    public void setSeasonC(String seasonC) {
        this.seasonC = seasonC;
    }

    public String getStyleNameC() {
        return styleNameC;
    }

    public void setStyleNameC(String styleNameC) {
        this.styleNameC = styleNameC;
    }

    public String getStyleNoC() {
        return styleNoC;
    }

    public void setStyleNoC(String styleNoC) {
        this.styleNoC = styleNoC;
    }

    public String getItemDescC() {
        return itemDescC;
    }

    public void setItemDescC(String itemDescC) {
        this.itemDescC = itemDescC;
    }

    public String getBrandC() {
        return brandC;
    }

    public void setBrandC(String brandC) {
        this.brandC = brandC;
    }

    public String getFitC() {
        return fitC;
    }

    public void setFitC(String fitC) {
        this.fitC = fitC;
    }

    public String getOrderQtyC() {
        return orderQtyC;
    }

    public void setOrderQtyC(String orderQtyC) {
        this.orderQtyC = orderQtyC;
    }

    public String getEndUserDescC() {
        return endUserDescC;
    }

    public void setEndUserDescC(String endUserDescC) {
        this.endUserDescC = endUserDescC;
    }

    public String getAttribute16() {
        return attribute16;
    }

    public void setAttribute16(String attribute16) {
        this.attribute16 = attribute16;
    }

    public String getAttribute17() {
        return attribute17;
    }

    public void setAttribute17(String attribute17) {
        this.attribute17 = attribute17;
    }

    public String getAttribute18() {
        return attribute18;
    }

    public void setAttribute18(String attribute18) {
        this.attribute18 = attribute18;
    }

    public String getAttribute19() {
        return attribute19;
    }

    public void setAttribute19(String attribute19) {
        this.attribute19 = attribute19;
    }

    public String getAttribute20() {
        return attribute20;
    }

    public void setAttribute20(String attribute20) {
        this.attribute20 = attribute20;
    }

    public String getAttribute21() {
        return attribute21;
    }

    public void setAttribute21(String attribute21) {
        this.attribute21 = attribute21;
    }

    public String getAttribute22() {
        return attribute22;
    }

    public void setAttribute22(String attribute22) {
        this.attribute22 = attribute22;
    }

    public String getAttribute23() {
        return attribute23;
    }

    public void setAttribute23(String attribute23) {
        this.attribute23 = attribute23;
    }

    public String getAttribute24() {
        return attribute24;
    }

    public void setAttribute24(String attribute24) {
        this.attribute24 = attribute24;
    }

    public String getAttribute25() {
        return attribute25;
    }

    public void setAttribute25(String attribute25) {
        this.attribute25 = attribute25;
    }

    public String getAttribute26() {
        return attribute26;
    }

    public void setAttribute26(String attribute26) {
        this.attribute26 = attribute26;
    }

    public String getAttribute27() {
        return attribute27;
    }

    public void setAttribute27(String attribute27) {
        this.attribute27 = attribute27;
    }

    public String getAttribute28() {
        return attribute28;
    }

    public void setAttribute28(String attribute28) {
        this.attribute28 = attribute28;
    }

    public String getAttribute29() {
        return attribute29;
    }

    public void setAttribute29(String attribute29) {
        this.attribute29 = attribute29;
    }

    public String getAttribute30() {
        return attribute30;
    }

    public void setAttribute30(String attribute30) {
        this.attribute30 = attribute30;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getStyleNameNew() {
        return styleNameNew;
    }

    public void setStyleNameNew(String styleNameNew) {
        this.styleNameNew = styleNameNew;
    }

    @Transactional
    public void validateEntity() {
        if (styleNoC == null && styleNameNew == null) {
            throw new IllegalArgumentException("You can't leave Style Name and Style No both Blank, please fill any one.");
        }
    }

    // Additional methods for DML operations can be added here
}
