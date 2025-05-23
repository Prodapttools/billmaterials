
package com.company.module.model;

import com.company.module.entities.MnjBomSizeDetImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Slf4j
@Entity
public class SizeWiseDetailVORowImpl {

    @Id
    @GeneratedValue
    private Long id; // Assuming an ID field for entity representation

    private Number actualQty;
    private Number addDeduct;
    private Number bomRmlineId;
    private Number bookingPercent;
    private Number detId;
    private String sizeVal;
    private Number sizeWiseBomReqQty;
    private Number sizeWiseOrderQty;
    private Number sizeWiseProjQty;
    private String flag;
    private Number actualQtyTotal;

    public SizeWiseDetailVORowImpl() {
    }

    public MnjBomSizeDetImpl getMnjBomSizeDet() {
        // TODO: Implement logic to retrieve MnjBomSizeDetImpl
        return null;
    }

    public Number getActualQty() {
        return actualQty;
    }

    public void setActualQty(Number actualQty) {
        this.actualQty = actualQty;
    }

    public Number getAddDeduct() {
        return addDeduct;
    }

    public void setAddDeduct(Number addDeduct) {
        this.addDeduct = addDeduct;
    }

    public Number getBomRmlineId() {
        return bomRmlineId;
    }

    public void setBomRmlineId(Number bomRmlineId) {
        this.bomRmlineId = bomRmlineId;
    }

    public Number getBookingPercent() {
        return bookingPercent;
    }

    public void setBookingPercent(Number bookingPercent) {
        this.bookingPercent = bookingPercent;
    }

    public Number getDetId() {
        return detId;
    }

    public void setDetId(Number detId) {
        this.detId = detId;
    }

    public String getSizeVal() {
        return sizeVal;
    }

    public void setSizeVal(String sizeVal) {
        this.sizeVal = sizeVal;
    }

    public Number getSizeWiseBomReqQty() {
        return sizeWiseBomReqQty;
    }

    public void setSizeWiseBomReqQty(Number sizeWiseBomReqQty) {
        this.sizeWiseBomReqQty = sizeWiseBomReqQty;
    }

    public Number getSizeWiseOrderQty() {
        return sizeWiseOrderQty;
    }

    public void setSizeWiseOrderQty(Number sizeWiseOrderQty) {
        this.sizeWiseOrderQty = sizeWiseOrderQty;
    }

    public Number getSizeWiseProjQty() {
        return sizeWiseProjQty;
    }

    public void setSizeWiseProjQty(Number sizeWiseProjQty) {
        this.sizeWiseProjQty = sizeWiseProjQty;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Number getActualQtyTotal() {
        // TODO: Implement logic to calculate total
        return actualQtyTotal;
    }

    public void setActualQtyTotal(Number actualQtyTotal) {
        this.actualQtyTotal = actualQtyTotal;
    }
}
