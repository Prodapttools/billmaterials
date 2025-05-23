
package com.company.module.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "mnj_bom_size_det")
@Getter
@Setter
public class MnjBomSizeDetImpl {

    private static final Logger logger = LoggerFactory.getLogger(MnjBomSizeDetImpl.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "det_id")
    private Long detId;

    @Column(name = "bom_rmline_id")
    private Long bomRmlineId;

    @Column(name = "size_val")
    private String sizeVal;

    @Column(name = "size_wise_order_qty")
    private Long sizeWiseOrderQty;

    @Column(name = "size_wise_bom_req_qty")
    private Long sizeWiseBomReqQty;

    @Column(name = "booking_percent")
    private Long bookingPercent;

    @Column(name = "size_wise_proj_qty")
    private Long sizeWiseProjQty;

    @Column(name = "add_deduct")
    private Long addDeduct;

    @Column(name = "actual_qty")
    private Long actualQty;

    @Column(name = "flag")
    private String flag;

    @ManyToOne
    @JoinColumn(name = "cust_mnj_ont_bom_rmline_lines_id")
    private CustMnjOntBomRmlineLinesImpl custMnjOntBomRmlineLines;

    @Transactional
    public void create() {
        // Logic to create a new instance, if needed
        logger.info("Creating new MnjBomSizeDetImpl instance");
    }

    public static MnjBomSizeDetImpl createPrimaryKey(Long detId) {
        MnjBomSizeDetImpl instance = new MnjBomSizeDetImpl();
        instance.setDetId(detId);
        return instance;
    }
}
