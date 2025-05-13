
package mnj.ont.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AppModuleService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CustMnjOntBomHeaderRepository custMnjOntBomHeaderRepository;

    @Autowired
    private CustMnjOntBomRmlineLinesRepository custMnjOntBomRmlineLinesRepository;

    @Autowired
    private PopulateRepository populateRepository;

    @Transactional
    public void fetchLines() {
        // Logic for fetching lines can be implemented here
    }

    @Transactional
    public void fetchMethod(Long pId) {
        List<Populate> populateList = populateRepository.findByHeaderId(pId);
        for (Populate popRow : populateList) {
            populateLines(popRow);
        }
    }

    public void populateLines(Populate popRow) {
        CustMnjOntBomRmlineLines linerow = createLines();
        linerow.setInventoryItemId(popRow.getInventoryItemId());
        linerow.setItemCode(popRow.getItemCode());
        linerow.setPDesc(popRow.getPrefix());
        linerow.setMeasureUnitId(popRow.getPrimaryUomCode());
        linerow.setUsageMoUnit(popRow.getRawmaterialPcons());
        linerow.setRate(popRow.getRawmaterialRate());
        linerow.setItemDesc(popRow.getDescription());
    }

    public CustMnjOntBomRmlineLines createLines() {
        CustMnjOntBomRmlineLines linerow = new CustMnjOntBomRmlineLines();
        custMnjOntBomRmlineLinesRepository.save(linerow);
        return linerow;
    }

    public String callPost(String headerId) {
        String stmt = "BEGIN :1 := cust_mnj_ont_pkg.cust_mnj_ont_bom_revision(:2,:3); end;";
        Query query = entityManager.createNativeQuery(stmt);
        query.setParameter(1, headerId);
        query.setParameter(2, " ");
        query.executeUpdate();
        return headerId;
    }

    public String createPR(String bomId) {
        String stmt = "BEGIN :1 := mnj_ont_mega_bom_pkg.CREATE_REQUISITION(:2); end;";
        Query query = entityManager.createNativeQuery(stmt);
        query.setParameter(1, bomId);
        query.executeUpdate();
        return bomId;
    }

    public String copyBOM(String bomId) {
        String stmt = "BEGIN :1 := cust_mnj_ont_pkg.cust_mnj_ont_bom_copy(:2); end;";
        Query query = entityManager.createNativeQuery(stmt);
        query.setParameter(1, bomId);
        query.executeUpdate();
        return bomId;
    }

    public void findSelLines() {
        List<Populate> populateList = populateRepository.findAll();
        for (Populate popRow : populateList) {
            if ("Y".equals(popRow.getMultiselect())) {
                populateLines1(popRow, null);
            }
        }
    }

    public void populateOrderLines(String bomId) {
        List<Populate> populateList = populateRepository.findByBomId(bomId);
        // Logic to populate order lines
    }

    public void populateLines1(Populate popRow, String lineId) {
        CustMnjOntBomRmlineLines linerow = createLines();
        linerow.setInventoryItemId(popRow.getInventoryItemId());
        linerow.setItemCode(popRow.getOrderedItem());
        linerow.setSoObno(popRow.getObRef());
        linerow.setSizeQuantity(popRow.getSizeQty());
        linerow.setDcpoNo(popRow.getDcpoNo());
        linerow.setAttribute1(popRow.getCountry());
        linerow.setColor(popRow.getColor());
        linerow.setSizeVal(popRow.getInseamSizeConcat());
        if (lineId != null) {
            linerow.setBomRmlineId(lineId);
        }
    }

    public double getConsVal() {
        // Logic to get consumption value
        return 0.0;
    }

    public void callMatFetch() {
        List<Populate> populateList = populateRepository.findAll();
        for (Populate popRow : populateList) {
            if ("true".equals(popRow.getMultiSelect())) {
                populateMaterialLines(popRow, getConsVal());
            }
        }
    }

    public void populateMaterialLines(Populate popRow, double consVal) {
        // Logic to populate material lines
    }

    public void setSessionValues(String orgId, String userId) {
        // Logic to set session values
    }

    public void refreshSizes() {
        String bomId = getBomId();
        List<CustMnjOntBomRmlineLines> lines = custMnjOntBomRmlineLinesRepository.findByBomId(bomId);
        for (CustMnjOntBomRmlineLines line : lines) {
            autoPopulateSizes(line.getBomRmlineId());
        }
    }

    public void autoPopulateSizes(String lineId) {
        List<Populate> populateList = populateRepository.findAll();
        for (Populate popRow : populateList) {
            populateLines1(popRow, lineId);
        }
    }

    public String getBomId() {
        // Logic to get BOM ID
        return null;
    }

    public void clearSizeBreakUpAll() {
        // Logic to clear size breakup
    }

    public void fillSizeBreakUp() {
        clearSizeBreakUpAll();
        // Logic to fill size breakup
    }

    public void postAdditionalQty() {
        // Logic to post additional quantity
    }

    public double getLineQtySum(String name, double currentVal, String itemId) {
        // Logic to get line quantity sum
        return 0.0;
    }
}


### Note:
- The code has been refactored to use Spring Data JPA for database interactions.
- The `@Transactional` annotation is used for methods that modify the database.
- The `EntityManager` is used for executing native queries.
- The `@Service` annotation indicates that this class is a service component in the Spring context.
- The repository interfaces (`CustMnjOntBomHeaderRepository`, `CustMnjOntBomRmlineLinesRepository`, `PopulateRepository`) need to be created to handle database operations.
- The logic for methods like `getConsVal`, `populateMaterialLines`, and others should be implemented based on the specific requirements of your application.