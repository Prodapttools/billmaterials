
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
        try (HSSFWorkbook workbook = new HSSFWorkbook(); OutputStream outputStream = response.getOutputStream()) {
            HSSFSheet worksheet = workbook.createSheet("BOM");
            createExcelRow(worksheet);

            // Define styles
            HSSFCellStyle headerStyle = createHeaderStyle(workbook);
            HSSFCellStyle dataStyle = createDataStyle(workbook);
            HSSFCellStyle titleStyle = createTitleStyle(workbook);
            HSSFCellStyle boldStyle = createBoldStyle(workbook);

            // Generate report content
            int xlRow = 0;
            String unit = getUnitName();
            xlRow = createTitle(worksheet, titleStyle, xlRow, unit);
            xlRow = createHeader(worksheet, headerStyle, xlRow);
            xlRow = populateData(worksheet, dataStyle, xlRow);

            // Write to output
            workbook.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            log.error("Error generating report", e);
        }
    }

    private HSSFCellStyle createHeaderStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }

    private HSSFCellStyle createDataStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }

    private HSSFCellStyle createTitleStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 14);
        style.setFont(font);
        return style;
    }

    private HSSFCellStyle createBoldStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }

    private int createTitle(HSSFSheet worksheet, HSSFCellStyle titleStyle, int xlRow, String unit) {
        HSSFRow row = worksheet.createRow(xlRow++);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("Report for " + unit);
        cell.setCellStyle(titleStyle);
        worksheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        return xlRow;
    }

    private int createHeader(HSSFSheet worksheet, HSSFCellStyle headerStyle, int xlRow) {
        HSSFRow row = worksheet.createRow(xlRow++);
        String[] headers = {"SL", "SUPPLIER CODE", "DETAIL", "COLOR", "Booking Qty", "Delivery Date"};
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
        return xlRow;
    }

    private int populateData(HSSFSheet worksheet, HSSFCellStyle dataStyle, int xlRow) {
        // Example data population logic
        // Replace with actual data retrieval logic
        for (int i = 1; i <= 10; i++) {
            HSSFRow row = worksheet.createRow(xlRow++);
            row.createCell(0).setCellValue(i);
            row.createCell(1).setCellValue("Supplier " + i);
            row.createCell(2).setCellValue("Detail " + i);
            row.createCell(3).setCellValue("Color " + i);
            row.createCell(4).setCellValue(i * 10);
            row.createCell(5).setCellValue("2023-10-01");
            for (int j = 0; j < 6; j++) {
                row.getCell(j).setCellStyle(dataStyle);
            }
        }
        return xlRow;
    }

    private String getUnitName() {
        // Logic to determine the unit name
        return "COLUMBIA APPARELS LTD."; // Example
    }

    private void createExcelRow(HSSFSheet worksheet) {
        for (int i = 0; i < 500; i++) {
            worksheet.createRow(i);
        }
    }
}
