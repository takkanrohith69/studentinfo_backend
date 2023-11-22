package com.jsp.Studentpage.Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jsp.Studentpage.dto.Student;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {

    public static ByteArrayInputStream exportToExcel(List<Student> data) throws IOException {
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Data");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Name");
            headerRow.createCell(2).setCellValue("Percentage");
            headerRow.createCell(3).setCellValue("Branch");
            headerRow.createCell(4).setCellValue("Email");
            headerRow.createCell(5).setCellValue("Phone");
            headerRow.createCell(6).setCellValue("Father_name");

            int rowNum = 1;
            for (Student item : data) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(item.getId());
                row.createCell(1).setCellValue(item.getName());
                row.createCell(2).setCellValue(item.getPercentage());
                row.createCell(3).setCellValue(item.getBranch());
                row.createCell(4).setCellValue(item.getEmail());
                row.createCell(5).setCellValue(item.getPhone());
                row.createCell(6).setCellValue(item.getFather_name());
                
            }
            
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());

        }
    }
}