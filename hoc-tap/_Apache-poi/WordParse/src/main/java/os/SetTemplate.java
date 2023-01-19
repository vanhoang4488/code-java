package os;

import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;
import com.spire.doc.formatting.CharacterFormat;
import com.spire.doc.formatting.ParagraphFormat;
import com.spire.doc.formatting.RowFormat;
import org.springframework.core.io.ClassPathResource;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SetTemplate {

    public static void main (String[] args) throws IOException {
        // Cot 1
        String area = "So gd&dt thai binh";
        String school = "Truong THCS Ha Noi";
        String inline = "--------------------";
        String pageSize = "(De thi co ___ trang)";

        // Cot 2
        String examName = "Kiem tra cuoi ky";
        String schoolYear = "Nam hoc 2022 - 2023";
        String branch = "Mon: __________";
        String examTime = "Thoi gian lam bai: ___ phut";
        String notice = "(khong ke thoi gian phat de)";

        // ho va ten
        String fullName = "Ho va ten: .......................................";
        String sbd = "So bao danh: ..........";
        String examCode = "Ma de 100";

        File file = new ClassPathResource("de_mau.docx").getFile();
        Document document = new Document(new FileInputStream(file));

        // set cot 1 va cot 2 into word
        Section section = document.getLastSection();
        Table table = section.addTable();

        TableRow row = table.addRow();
        // set cot 1
        TableCell cell = row.addCell();
        cell.setCellWidthType(CellWidthType.Percentage);
        cell.setScaling(2);
        Paragraph paragraph = cell.addParagraph();
        ParagraphFormat format = paragraph.getFormat();
        format.setHorizontalAlignment(HorizontalAlignment.Center);
        TextRange textRange = paragraph.appendText(area.toUpperCase()); textRange.applyCharacterFormat(format1()); paragraph.appendBreak(BreakType.Line_Break);
        TextRange textRange1 = paragraph.appendText(school.toUpperCase()); textRange1.applyCharacterFormat(format1()); paragraph.appendBreak(BreakType.Line_Break);
        paragraph.appendText(inline); paragraph.appendBreak(BreakType.Line_Break);
        paragraph.appendText(pageSize);

        // cot 2
        TableCell cell1 = row.addCell();
        cell1.setCellWidthType(CellWidthType.Percentage);
        cell1.setScaling(2);
        Paragraph paragraph1 = cell1.addParagraph();
        ParagraphFormat format1 = paragraph1.getFormat();
        format1.setHorizontalAlignment(HorizontalAlignment.Center);
        TextRange textRange2 = paragraph1.appendText(examName.toUpperCase()); textRange2.applyCharacterFormat(bold()); paragraph1.appendBreak(BreakType.Line_Break);
        TextRange textRange3 = paragraph1.appendText(schoolYear.toUpperCase()); textRange3.applyCharacterFormat(bold()); paragraph1.appendBreak(BreakType.Line_Break);
        TextRange textRange4 = paragraph1.appendText(branch.toUpperCase()); textRange4.applyCharacterFormat(bold()); paragraph1.appendBreak(BreakType.Line_Break);
        paragraph1.appendText(examTime); paragraph1.appendBreak(BreakType.Line_Break);
        paragraph1.appendText(notice);

        Paragraph line = section.addParagraph();

        // set fullname
        Table table1 = section.addTable();
        RowFormat rowFormat = table1.getTableFormat();
        rowFormat.getBorders().getBottom().setBorderType(BorderStyle.Basic_Thin_Lines);
        rowFormat.getBorders().getBottom().setLineWidth(2.0F);
        TableRow row1 = table1.addRow();
        TableCell cell2 = row1.addCell();
        cell2.setCellWidthType(CellWidthType.Percentage);cell2.setScaling(4);
        Paragraph paragraph2 = cell2.addParagraph();
        paragraph2.appendText(fullName);

        TableCell cell3 = row1.addCell();
        cell3.setCellWidthType(CellWidthType.Percentage);cell3.setScaling(2);
        Paragraph paragraph3 = cell3.addParagraph();
        paragraph3.appendText(sbd);

        TableCell cell4 = row1.addCell();
        cell4.setCellWidthType(CellWidthType.Percentage); cell4.setScaling(1);
        Paragraph paragraph4 = cell4.addParagraph();
        TextRange textRange5 = paragraph4.appendText(examCode);
        textRange5.applyCharacterFormat(bold());

        document.saveToFile(new FileOutputStream(new ClassPathResource("outFile.docx").getFile()), FileFormat.Docx_2013);
    }

    private static CharacterFormat bold () {
        CharacterFormat cf = new CharacterFormat();
        cf.setBold(true);
        return cf;
    }

    private static CharacterFormat format1 () {
        CharacterFormat cf = new CharacterFormat();
        cf.setBold(true);
        cf.setTextColor(Color.RED);
        return cf;
    }
}
