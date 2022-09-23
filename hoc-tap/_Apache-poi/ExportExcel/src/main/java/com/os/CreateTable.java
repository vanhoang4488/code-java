package com.os;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateTable {

    public static void main(String[] args) throws IOException {
        other();
    }

    /**
     * code của bản thân
     * sheet.createTable() đã nỗi thời.
     */
    private static void custom() throws IOException {
        List<String> values = new ArrayList<>();
        values.add("header");
        values.add("cell");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("create table");

        // tạo bảng
        CellReference topLeft = new CellReference(0, 0);
        CellReference bottomRight = new CellReference(values.size() - 1, 0);
        AreaReference areaReference = new AreaReference("A1:A2",SpreadsheetVersion.EXCEL2007);
        XSSFTable table = sheet.createTable(areaReference); // lỗi thời

        // cấu hình table
        CTTable ctTable = table.getCTTable();
        ctTable.setId(1);
        ctTable.setName("custom");
        ctTable.setTotalsRowShown(false);

        CTTableStyleInfo tableStyle = ctTable.addNewTableStyleInfo();
        tableStyle.setName("1123234");
        tableStyle.setShowColumnStripes(true);
        tableStyle.setShowRowStripes(true);

        // tạo header
        CTTableColumns headers = ctTable.addNewTableColumns();
        headers.setCount(values.size());
        for(int i = 0; i < values.size(); i++){
            CTTableColumn header = headers.addNewTableColumn();
            header.setName(values.get(i));
        }

        FileOutputStream out = new FileOutputStream(new File("createtable.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("createtable.xlsx written successfully");
    }

    /**
     * code chép trên mạng
     */
    private static void other() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("createtable");

        //XSSFTable table = sheet.createTable();
        XSSFTable table = sheet.createTable(null); //since apache poi 4.0.0
        CTTable cttable = table.getCTTable();

        cttable.setDisplayName("Table1");
        //cttable.setId(1);
        //cttable.setName("Test");
        String bottomLeft = String.valueOf((char) (64 + 3)) + 11;
        System.out.println("======> " + bottomLeft);
        cttable.setRef("A1:" + bottomLeft);
        //cttable.setTotalsRowShown(true);

        CTTableStyleInfo styleInfo = cttable.addNewTableStyleInfo();
        styleInfo.setName("TableStyleMedium2"); // bắt buộc phải có thì mới hiện bảng, và ghi giống hệt tên này
        styleInfo.setShowColumnStripes(false);
        styleInfo.setShowRowStripes(true);

        CTTableColumns columns = cttable.addNewTableColumns();
        columns.setCount(3); // số lượng cột không thể lệch, với ctTable.setRef nếu không sẽ không tạo được bảng.
        for (int i = 1; i <= 3; i++) { /**phải đặc biệt chú ý vấn đề này I bắt đầu từ 1*/
            CTTableColumn column = columns.addNewTableColumn();
            column.setId(i);
            column.setName("Column" + i);
        }

        for (int r = 0; r < 2; r++) { /**hàng chèn dữ liệu bắt đầu từ vị trí header là 0*/
            XSSFRow row = sheet.createRow(r);
            for(int c = 0; c < 3; c++) {
                XSSFCell cell = row.createCell(c);
                if(r == 0) { //first row is for column headers
                    cell.setCellValue("Column"+ (c+1)); //content **must** be here for table column names
                } else {
                    //cell.setCellValue("Data R"+ (r+1) + "C" + (c+1));
                }
            }
        }

        FileOutputStream out = new FileOutputStream(new File("createtable.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("createtable.xlsx written successfully");
    }
}
