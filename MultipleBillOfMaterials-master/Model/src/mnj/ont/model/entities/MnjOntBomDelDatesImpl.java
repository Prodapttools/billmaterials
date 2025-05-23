
package com.company.module.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "MNJ_ONT_BOM_DEL_DATES")
@Getter
@Setter
@NoArgsConstructor
public class MnjOntBomDelDatesImpl {

    private static final Logger logger = LoggerFactory.getLogger(MnjOntBomDelDatesImpl.class);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mnj_ont_bom_del_dates_seq")
    @SequenceGenerator(name = "mnj_ont_bom_del_dates_seq", sequenceName = "MNJ_ONT_BOM_DEL_DATES_S", allocationSize = 1)
    private Long detailId;

    @Column(name = "BOM_RMLINE_ID")
    private Long bomRmlineId;

    @Column(name = "DELIVERY_DATE")
    private java.util.Date deliveryDate;

    @Column(name = "QTY")
    private Long qty;

    @ManyToOne
    @JoinColumn(name = "CUST_MNJ_ONT_BOM_RMLINE_LINES_ID")
    private CustMnjOntBomRmlineLinesImpl custMnjOntBomRmlineLines;

    @PrePersist
    public void prePersist() {
        logger.info("Creating a new MnjOntBomDelDatesImpl instance");
    }
}
