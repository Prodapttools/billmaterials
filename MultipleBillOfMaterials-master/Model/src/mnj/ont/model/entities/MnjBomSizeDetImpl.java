
package mnj.ont.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "mnj_bom_size_det")
public class MnjBomSizeDet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "det_id")
    private Long detId;

    @Column(name = "bom_rmline_id")
    private Long bomRmlineId;

    @Column(name = "size_val")
    private String sizeVal;

    @Column(name = "size_wise_order_qty")
    private BigDecimal sizeWiseOrderQty;

    @Column(name = "size_wise_bom_req_qty")
    private BigDecimal sizeWiseBomReqQty;

    @Column(name = "booking_percent")
    private BigDecimal bookingPercent;

    @Column(name = "size_wise_proj_qty")
    private BigDecimal sizeWiseProjQty;

    @Column(name = "add_deduct")
    private BigDecimal addDeduct;

    @Column(name = "actual_qty")
    private BigDecimal actualQty;

    @Column(name = "flag")
    private String flag;

    @ManyToOne
    @JoinColumn(name = "cust_mnj_ont_bom_rmline_lines_id")
    private CustMnjOntBomRmlineLines custMnjOntBomRmlineLines;
}
