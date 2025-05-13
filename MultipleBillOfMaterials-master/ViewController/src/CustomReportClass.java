
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

@Service
@Slf4j
public class CustomReportService {

    @Autowired
    private AppModuleImpl appModule;

    public void generateReport(HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("BOM");
        createExcelRows(worksheet, 500);

        // Define styles
        HSSFCellStyle headerStyle = createHeaderStyle(workbook);
        HSSFCellStyle dataStyle = createDataStyle(workbook);
        HSSFCellStyle titleHeaderStyle = createTitleHeaderStyle(workbook);
        HSSFCellStyle boldStyle = createBoldStyle(workbook);

        // Generate report content
        int xlRow = 0;
        int colStart = 0;

        // Title and header
        String unit = getUnitName();
        titleHeader(xlRow++, colStart + 1, unit, worksheet, titleHeaderStyle);
        xlRow += 2;

        // Add data
        addDataToWorksheet(worksheet, xlRow, colStart, headerStyle, dataStyle);

        // Write to response
        try (OutputStream outputStream = response.getOutputStream()) {
            workbook.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            log.error("Error writing report to output stream", e);
        }
    }

    private void addDataToWorksheet(HSSFSheet worksheet, int xlRow, int colStart, HSSFCellStyle headerStyle, HSSFCellStyle dataStyle) {
        // Example of adding data
        HSSFRow row = worksheet.createRow(xlRow++);
        HSSFCell cell = row.createCell(colStart);
        cell.setCellValue("Header");
        cell.setCellStyle(headerStyle);

        // Add more data rows as needed
        for (int i = 0; i < 10; i++) {
            row = worksheet.createRow(xlRow++);
            cell = row.createCell(colStart);
            cell.setCellValue("Data " + i);
            cell.setCellStyle(dataStyle);
        }
    }

    private String getUnitName() {
        // Logic to determine the unit name
        return "Unit Name"; // Placeholder
    }

    private void titleHeader(int xlRow, int xlCol, String headerText, HSSFSheet worksheet, HSSFCellStyle titleHeaderStyle) {
        HSSFRow excelRow = worksheet.createRow(xlRow);
        HSSFCell excelCell = excelRow.createCell(xlCol);
        excelCell.setCellValue(headerText);
        CellRangeAddress cellRange = new CellRangeAddress(xlRow, xlRow, xlCol, xlCol + 5);
        worksheet.addMergedRegion(cellRange);
        excelCell.setCellStyle(titleHeaderStyle);
    }

    private HSSFCellStyle createHeaderStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        return style;
    }

    private HSSFCellStyle createDataStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setBorderBottom(BorderStyle.THIN);
        return style;
    }

    private HSSFCellStyle createTitleHeaderStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(createFont(workbook, 14, true));
        return style;
    }

    private HSSFCellStyle createBoldStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(createFont(workbook, 12, true));
        return style;
    }

    private HSSFFont createFont(HSSFWorkbook workbook, int fontSize, boolean bold) {
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) fontSize);
        font.setBold(bold);
        return font;
    }

    private void createExcelRows(HSSFSheet worksheet, int numberOfRows) {
        for (int i = 0; i < numberOfRows; i++) {
            worksheet.createRow(i);
        }
    }
}
