package com.os;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CreateTable2 {

    public static void main(String[] args) throws IOException {
        List<String[]> dataList = new ArrayList<>();
        String[] a = new String[]{"header1", "header2"};
        String[] b = new String[]{"value1", "value2"};
        String[] c = new String[]{"value3", "value4"};
        dataList.add(a);
        dataList.add(b);
        dataList.add(c);

        genericExcel("table", dataList);
    }

    public static XSSFWorkbook genericExcel(String sheetName, List<String[]> dataList) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);

        String[] headerNames = dataList.get(0);
        CTTable ctTable = createTable(sheet, dataList.size(), headerNames.length);

        addTableHeader(ctTable, headerNames);

        addTableData(workbook, sheetName, dataList);

        FileOutputStream out = new FileOutputStream(new File("createtable2.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("createtable2.xlsx written successfully");
        return workbook;
    }

    private static CTTable createTable(XSSFSheet sheet, int rows, int cols){
        XSSFTable table = sheet.createTable(null); //since apache poi 4.0.0
        CTTable cttable = table.getCTTable();

        cttable.setDisplayName("Table1");
        //cttable.setId(1);
        //cttable.setName("Test");
        String bottomLeft = String.valueOf((char) (64 + cols)) + 11;
        System.out.println("======> " + bottomLeft);
        cttable.setRef("A1:" + bottomLeft);
        //cttable.setTotalsRowShown(true);

        CTTableStyleInfo styleInfo = cttable.addNewTableStyleInfo();
        styleInfo.setName("TableStyleMedium2"); // bắt buộc phải có thì mới hiện bảng, và ghi giống hệt tên này
        styleInfo.setShowColumnStripes(false);
        styleInfo.setShowRowStripes(true);
        return cttable;
    }

    private static void addTableHeader(CTTable cttable, String[] headerNames){
        CTTableColumns columns = cttable.addNewTableColumns();
        columns.setCount(headerNames.length); // số lượng cột không thể lệch, với ctTable.setRef nếu không sẽ không tạo được bảng.
        for (int i = 1; i <= headerNames.length; i++) { /**phải đặc biệt chú ý vấn đề này I bắt đầu từ 1*/
            CTTableColumn column = columns.addNewTableColumn();
            column.setId(i);
            column.setName("Column" + i);
        }
    }

    public static void addTableData(XSSFWorkbook workbook, String sheetName, List<String[]> dataList) {
        XSSFSheet sheet = workbook.getSheet(sheetName);
        for (int r = 0; r < dataList.size(); r++) { /**hàng chèn dữ liệu bắt đầu từ vị trí header là 0*/
            XSSFRow row = sheet.createRow(r);
            String[] strList = dataList.get(r);
            for(int c = 0; c < strList.length; c++) {
                XSSFCell cell = row.createCell(c);
                if(r == 0) { /**đây mới là nơi chèn nội dung của headers*/
                    cell.setCellValue(strList[c]); //content **must** be here for table column names
                } else {
                    cell.setCellValue(strList[c]);
                }
            }
        }
    }

    private static void genExcelCell(XSSFRow row, String[] cellValues){
        for(int i = 0; i < cellValues.length; i++){
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(cellValues[i]);
        }
    }
}
