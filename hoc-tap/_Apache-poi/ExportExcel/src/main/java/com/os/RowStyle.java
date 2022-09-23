package com.os;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Hiện tại theo thông tin trên stackflow
 * source code của XSSF không hỗ trợ thay đôi kiểu của hàng
 * mọi sự thay đổi style trên hàng đều không ảnh hưởng đến style trên cột.
 * => phải áp dụng style trên từng cột riêng lẻ.
 */
public class RowStyle {

    public static void main(String[] args)throws Exception {
        setCellStyle();
    }

    private static void setCellStyle() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("rowstyle");

        XSSFCellStyle defaultStyle = workbook.createCellStyle();
        defaultStyle.setAlignment(HorizontalAlignment.CENTER);
        defaultStyle.setBorderBottom(BorderStyle.THIN);
        defaultStyle.setBorderTop(BorderStyle.THIN);
        defaultStyle.setBorderLeft(BorderStyle.THIN);
        defaultStyle.setBorderRight(BorderStyle.THIN);
        defaultStyle.setBottomBorderColor(IndexedColors.BLUE.getIndex());
        defaultStyle.setTopBorderColor(IndexedColors.BLUE.getIndex());
        defaultStyle.setLeftBorderColor(IndexedColors.BLUE.getIndex());
        defaultStyle.setRightBorderColor(IndexedColors.BLUE.getIndex());
        XSSFFont defaultFont = workbook.createFont();
        defaultFont.setBold(false);
        defaultFont.setFontHeightInPoints((short) 14);
        defaultFont.setFontName("Times New Roman");
        defaultStyle.setFont(defaultFont);

        XSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.DIAMONDS);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBottomBorderColor(IndexedColors.BLUE.getIndex());
        headerStyle.setTopBorderColor(IndexedColors.BLUE.getIndex());
        headerStyle.setLeftBorderColor(IndexedColors.BLUE.getIndex());
        headerStyle.setRightBorderColor(IndexedColors.BLUE.getIndex());
        XSSFFont headerFont = workbook.createFont();
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setFontName("Times New Roman");
        headerStyle.setFont(headerFont);

        XSSFRow header = sheet.createRow(0);
        XSSFCell cell1 = header.createCell(0);
        cell1.setCellValue("Header");
        cell1.setCellStyle(headerStyle);

        XSSFRow row = sheet.createRow(1);
        XSSFCell cell2 = row.createCell(0);
        cell2.setCellValue("Cell");
        cell2.setCellStyle(defaultStyle);


        FileOutputStream out = new FileOutputStream(new File("rowstyle.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("rowstyle.xlsx written successfully");
    }

    /**
     * thất bại
     */
    private static void setRowStyleFail() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("rowstyle");

        XSSFCellStyle defaultStyle = workbook.createCellStyle();
        XSSFFont defaultFont = workbook.createFont();
        defaultFont.setFontName("Times New Roman");
        defaultFont.setFontHeightInPoints((short) 14);
        defaultFont.setBold(false);
        defaultStyle.setFont(defaultFont);

        XSSFFont headerFont = workbook.createFont();
        defaultFont.setFontName("Times New Roman");
        headerFont.setFontHeightInPoints((short) 14);
        defaultFont.setBold(true);

        XSSFRow header = sheet.createRow(0);
        XSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
        headerStyle.setFont(headerFont);
        header.setRowStyle(headerStyle);
        XSSFCell cell = header.createCell(0);
        cell.setCellValue("Header");

        XSSFRow row = sheet.createRow(1);
        XSSFCell cell2 = row.createCell(0);
        cell2.setCellValue("Header");


        FileOutputStream out = new FileOutputStream(new File("rowstyle.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("rowstyle.xlsx written successfully");
    }

}
