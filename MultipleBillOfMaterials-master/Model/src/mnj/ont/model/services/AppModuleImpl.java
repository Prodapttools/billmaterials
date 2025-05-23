
package com.company.module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class AppModuleImpl {

    @Autowired
    private DataSource dataSource;

    public AppModuleImpl() {
    }

    public void fetchLines() {
        return;
    }

    public void fetchMethod(Long pId) {
        // Implementation for fetching data based on pId
    }

    public void showRecords() {
    }

    public void populateLines(Row poprow) {
        Row linerow = createLines();
        linerow.setAttribute("InventoryItemId", getPopulateValue(poprow, "InventoryItemId"));
        linerow.setAttribute("ItemCode", getPopulateValue(poprow, "ItemCode"));
        linerow.setAttribute("PDesc", getPopulateValue(poprow, "Prefix"));
        linerow.setAttribute("MeasureUnitId", getPopulateValue(poprow, "PrimaryUomCode"));
        linerow.setAttribute("UsageMoUnit", getPopulateValue(poprow, "RawmaterialPcons"));
        linerow.setAttribute("Rate", getPopulateValue(poprow, "RawmaterialRate"));
        linerow.setAttribute("ItemDesc", getPopulateValue(poprow, "Description"));
    }

    public Row createLines() {
        // Implementation for creating lines
        return new Row();
    }

    public String getPopulateValue(Row r, String columnName) {
        String value = null;
        try {
            value = r.getAttribute(columnName).toString();
        } catch (Exception e) {
            // Handle exception
        }
        return value;
    }

    public int callPost(String headerId) {
        int srno = 0;
        String stmt = "BEGIN :1 := cust_mnj_ont_pkg.cust_mnj_ont_bom_revision(:2,:3); end;";
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(stmt)) {
            cs.registerOutParameter(1, java.sql.Types.VARCHAR);
            cs.setString(2, headerId);
            cs.setString(3, " ");
            cs.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return srno;
    }

    public String createPR(String bomId, String bomLineId) {
        String stmt = "BEGIN :1 := mnj_ont_mega_bom_pkg.CREATE_REQUISITION(:2); end;";
        String prNo = null;

        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(stmt)) {
            cs.registerOutParameter(1, java.sql.Types.VARCHAR);
            cs.setString(2, bomId);
            cs.execute();
            prNo = cs.getString(1);
        } catch (Exception e) {
            prNo = e.getMessage();
        }

        return prNo;
    }

    public String copyBOM(String bomId) {
        String stmt = "BEGIN :1 := cust_mnj_ont_pkg.cust_mnj_ont_bom_copy(:2); end;";
        String bomNo = null;
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(stmt)) {
            cs.registerOutParameter(1, java.sql.Types.VARCHAR);
            cs.setString(2, bomId);
            cs.execute();
            bomNo = cs.getString(1);
        } catch (Exception e) {
            bomNo = e.getMessage();
        }

        return bomNo;
    }

    public void findSelLines() {
        // Implementation for finding selected lines
    }

    public void populateOrderLines(String bomId) {
        // Implementation for populating order lines
    }

    public void populateLines1(Row poprow, String lineId) {
        Row linerow = createLines();
        linerow.setAttribute("InventoryItemId", getPopulateValue(poprow, "InventoryItemId"));
        linerow.setAttribute("ItemCode", getPopulateValue(poprow, "OrderedItem"));
        linerow.setAttribute("SoObno", getPopulateValue(poprow, "ObRef"));
        linerow.setAttribute("SizeQuantity", getPopulateValue(poprow, "SizeQty"));
        linerow.setAttribute("DcpoNo", getPopulateValue(poprow, "DcpoNo"));
        linerow.setAttribute("Attribute1", getPopulateValue(poprow, "Country"));
        linerow.setAttribute("Color", getPopulateValue(poprow, "Color"));
        linerow.setAttribute("SizeVal", getPopulateValue(poprow, "InseamSizeConcat"));
        linerow.setAttribute("Linerefno", getPopulateValue(poprow, "HeaderId"));

        if (lineId != null) {
            linerow.setAttribute("BomRmlineId", lineId);
        }
    }

    public Row createLinesSTN() {
        // Implementation for creating lines STN
        return new Row();
    }

    public double geConsVal() {
        // Implementation for getting consumption value
        return 0.0;
    }

    public void callMatFetch() {
        // Implementation for fetching material
    }

    public int checkOrgAssignment(Row r) throws SQLException {
        // Implementation for checking organization assignment
        return 0;
    }

    public boolean checkDuplicate(Row row) {
        // Implementation for checking duplicates
        return false;
    }

    public void populateMaterialLines(Row poprow, double consVal) throws SQLException {
        // Implementation for populating material lines
    }

    public Row createMaterialLines() {
        // Implementation for creating material lines
        return new Row();
    }

    public void afterCommit() {
        // Implementation for actions after commit
    }

    public void clearSizeBreakUpAll() {
        // Implementation for clearing size breakup
    }

    public void fillSizeBreakUp() {
        // Implementation for filling size breakup
    }

    public void setSizeBreakupValues(Row r, String size, int sizeQty) {
        // Implementation for setting size breakup values
    }

    public Row createSizeBreakup() {
        // Implementation for creating size breakup
        return new Row();
    }

    public void postAdditionalQty() {
        // Implementation for posting additional quantity
    }

    public double getLineQtySum(String name, double curntVal, String itemId) {
        // Implementation for getting line quantity sum
        return 0.0;
    }

    public static double numeric3(Object ob) {
        try {
            if (ob != null)
                return Double.parseDouble(String.valueOf(ob));
            else
                return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public static double changeToDouble(double n) {
        if (Double.isNaN(n)) {
            return 0;
        }
        if (Double.isInfinite(n)) {
            return 0;
        }
        return n;
    }

    public static double roundUp(double n) {
        String value = String.valueOf(n);
        if (!value.contains(".")) {
            return n;
        }
        char[] charArray = value.toCharArray();
        if (charArray.length - (value.substring(0, value.indexOf(".") + 1).length()) > 0) {
            BigDecimal bdTest1 = new BigDecimal(value);
            BigDecimal another = bdTest1.setScale(0, BigDecimal.ROUND_CEILING);
            return another.doubleValue();
        }
        return n;
    }
}
