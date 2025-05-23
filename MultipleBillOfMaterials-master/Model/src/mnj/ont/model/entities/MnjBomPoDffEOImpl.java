
package com.company.module.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Entity
@Table(name = "MNJ_BOM_PO_DFF")
@Getter
@Setter
@Component
public class MnjBomPoDffEOImpl {
    private static final Logger logger = LoggerFactory.getLogger(MnjBomPoDffEOImpl.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long headerId;

    private Long bomId;
    private Long orgId;
    private Long userId;
    private Long prNo;
    private String purchaseMode;
    private String shipMode;
    private String deliveryTerm;
    private String spoType;
    private String nominatedBy;
    private String partialShipment;
    private String excessShipment;
    private String actualSupplier;
    private Long actualSupplierId;

    @ManyToOne
    @JoinColumn(name = "CUST_MNJ_ONT_BOM_HEADER_ID")
    private CustMnjOntBomHeaderImpl custMnjOntBomHeader;

    public MnjBomPoDffEOImpl() {
    }

    @Transactional
    public void create(Map<String, Object> sessionScope) {
        // Assuming sessionScope is passed as a parameter
        String user = (String) sessionScope.get("userId");
        try {
            this.userId = Long.valueOf(user);
        } catch (NumberFormatException e) {
            logger.error("Error parsing userId", e);
        }
        // Additional logic for setting other attributes can be added here
    }

    @Transactional
    public void remove() {
        // Logic for removing the entity
    }

    @Transactional
    public void lock() {
        // Logic for locking the entity
    }

    @Transactional
    public void doDML(int operation, Map<String, Object> sessionScope) {
        String user = "2222"; // Placeholder for user
        String org = "2222";  // Placeholder for org

        if (operation == 1) { // Assuming 1 represents DML_INSERT
            try {
                this.orgId = Long.valueOf(org);
                this.userId = Long.valueOf(user);
            } catch (NumberFormatException e) {
                logger.error("Error parsing orgId or userId", e);
            }
        }
        // Additional logic for DML operations can be added here
    }
}
