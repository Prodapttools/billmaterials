
package mnj.ont.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "MNJ_BOM_BPO_LINES_ALL")
public class MnjBomBpoLinesAll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LINE_ID")
    private Long lineId;

    @Column(name = "BOM_ID")
    private BigDecimal bomId;

    @Column(name = "BPO_NO")
    private String bpoNo;

    @Column(name = "SALE_ORDER_ID")
    private BigDecimal saleOrderId;

    @Column(name = "SEAL_NO")
    private String sealeNo;

    @Column(name = "USER_ITEM_DESC")
    private String userItemDesc;

    @Column(name = "END_USER_DESC")
    private String endUserDesc;

    @Column(name = "ORDER_QTY")
    private BigDecimal orderQty;

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
    private CustMnjOntBomHeader custMnjOntBomHeader;

}
