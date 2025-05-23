
package com.company.module.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "MNJ_BOM_BPO_LINES_ALL")
@Getter
@Setter
@NoArgsConstructor
public class MnjBomBpoLinesAllImpl {

    private static final Logger logger = LoggerFactory.getLogger(MnjBomBpoLinesAllImpl.class);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mnj_bom_bpo_lines_all_seq")
    @SequenceGenerator(name = "mnj_bom_bpo_lines_all_seq", sequenceName = "MNJ_BOM_BPO_LINES_ALL_S", allocationSize = 1)
    private Long lineId;

    @Column(name = "BOM_ID")
    private Long bomId;

    @Column(name = "BPO_NO")
    private String bpoNo;

    @Column(name = "SALE_ORDER_ID")
    private Long saleOrderId;

    @Column(name = "SEALE_NO")
    private String sealeNo;

    @Column(name = "USER_ITEM_DESC")
    private String userItemDesc;

    @Column(name = "END_USER_DESC")
    private String endUserDesc;

    @Column(name = "ORDER_QTY")
    private Long orderQty;

    @Column(name = "FIT")
    private String fit;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "STYLE_NO")
    private String styleNo;

    @Column(name = "SEASON")
    private String season;

    @ManyToOne
    @JoinColumn(name = "CUST_MNJ_ONT_BOM_HEADER_ID")
    private CustMnjOntBomHeaderImpl custMnjOntBomHeader;

    @Transactional
    public void create() {
        logger.info("Creating new MnjBomBpoLinesAllImpl instance");
        // Additional logic for creation can be added here
    }
}
