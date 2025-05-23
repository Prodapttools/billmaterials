
package com.company.module.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class popuplineVORowImpl {
    private Number inventoryItemId;
    private Number headerId;
    private String obRef;
    private String orderedItem;
    private String description;
    private String dcpoNo;
    private Number inseamQty;
    private java.util.Date deliveryDate; // Using java.util.Date instead of oracle.jbo.domain.Date
    private String deliveryTerm;
    private String shipMode;
    private String country;
    private String inseamSizeConcat;
    private Number sizeQty;
    private String color;
    private Number bomId;
    private String inseem;
    private Number sizeId;
    private Number sizeValue;
    private String multiselect;

    public popuplineVORowImpl() {
    }
}
