
package com.company.module.service;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.OutputStream;
import java.util.Map;

@Service
public class CustomReportClass {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomReportClass.class);
    
    private HSSFWorkbook workbook = new HSSFWorkbook();
    private HSSFSheet worksheet = workbook.createSheet("BOM");
    private HSSFRow excelrow = null;
    private HSSFCell excelcell = null;

    private HSSFCellStyle tableHeaderStyle = workbook.createCellStyle();
    private HSSFCellStyle headerStyle = workbook.createCellStyle();
    private HSSFCellStyle dataStyle = workbook.createCellStyle();
    private HSSFCellStyle titleHeaderStyle = workbook.createCellStyle();
    private HSSFCellStyle titleStyle = workbook.createCellStyle();
    private HSSFCellStyle boldStyle = workbook.createCellStyle();
    private HSSFCellStyle italicStyle = workbook.createCellStyle();

    private int xlColLine = 0;
    private int xlLineRow = 0;

    @Transactional
    public void generateReport(OutputStream outputStream, Map<String, Object> sessionScope) {
        // Initialize styles and other configurations
        initializeStyles();

        // Generate the report content
        createExcelRow();
        // Add your report generation logic here...

        try {
            workbook.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            logger.error("Error writing workbook to output stream", e);
        }
    }

    private void initializeStyles() {
        // Initialize styles here...
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        // Set other styles...
    }

    private void createExcelRow() {
        for (int i = 0; i < 500; i++) {
            excelrow = worksheet.createRow(i);
        }
    }

    private void tableHeader(int end, int xlRow, int xlCol, String headerText) {
        excelrow = worksheet.getRow(xlRow);
        excelcell = excelrow.createCell(xlCol);
        excelcell.setCellValue(headerText);
        CellRangeAddress cellRange = new CellRangeAddress(
                xlRow, // first row (0-based)
                xlRow, // last row (0-based)
                xlCol, // first column (0-based)
                end + 2 // last column (0-based)
        );
        worksheet.addMergedRegion(cellRange);
        excelcell.setCellStyle(tableHeaderStyle);
    }

    private void printColNames(int start, int end, int xlRow, int xlCol) {
        excelcell = worksheet.getRow(xlRow).createCell(xlCol);
        excelcell.setCellValue("SL.");
        excelcell.setCellStyle(headerStyle);
        xlCol++;
        // Add other column names...
    }

    private void printData(int start, int end, int xlRow, int xlCol) {
        // Implement data printing logic...
    }

    // Additional methods for subtitle, addInfoLeftBold, etc.
}
