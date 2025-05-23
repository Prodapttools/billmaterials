
package com.company.module.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class CustMnjOntBomOblineDetailsImpl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bomOblineId;

    private Long bomId;
    private Long bomRmlineId;
    private Long solineId;
    private String soObno;
    private String inseamId;
    private String sizeId;
    private String linerefno;
    private String barcode;
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
    private Long sizeQuantity;
    private String itemCode;
    private Long lineNo;
    private Long inventoryItemId;
    private Long consumption;
    private Long withExtra;
    private String legacyBomtrid;
    private String legacyBomtrCid;
    private String legacyId;
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
    private String dcpoNo;
    private String color;
    private String sizeVal;
    private Long poQty;

    // Additional relationships can be defined here if needed
}
