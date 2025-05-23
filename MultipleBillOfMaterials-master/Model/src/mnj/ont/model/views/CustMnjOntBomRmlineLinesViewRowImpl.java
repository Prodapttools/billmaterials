
package com.company.module.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Getter
@Setter
public class CustMnjOntBomRmlineLinesViewRowImpl {

    private String itemDesc;
    private String supplierName;
    private String legacyCode;
    private BigDecimal prQty;
    private String lineStatus;
    private Object custMnjOntBomOblineDetailsView;
    private Object deliveryDatesVO;
    private Object sizeWiseDetailVO;
    private Object productionArea1;
    private Object componentLov1;
    private Object suppliersVO1;
    private Object uOMLov1;
    private Object excessBuyingVO1;
    private Object currencyVO1;
    private Object purchaseTypeVO1;

    public CustMnjOntBomRmlineLinesViewRowImpl() {
    }

    // Additional methods can be added here as needed
}
