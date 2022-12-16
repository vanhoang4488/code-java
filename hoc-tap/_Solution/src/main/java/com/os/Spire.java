package com.os;

import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.DocPicture;
import com.spire.doc.fields.TextRange;
import com.spire.doc.fields.omath.OfficeMath;
import com.spire.doc.formatting.CharacterFormat;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Spire {

    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine();

        List<Cursor> childs = new ArrayList<>();
        childs.add(new Cursor(CursorType.STRING, content));

        // find MathML
        List<Cursor> omaths = MathMLParser.getMathMLs(childs);
        if (!omaths.isEmpty()) childs = omaths;

        // find picture
        List<Cursor> imgs = ImageParse.getImages(childs);
        if (!imgs.isEmpty()) childs = imgs;

        List<Cursor> tables = TableParser.getTable(childs);
        if (!tables.isEmpty()) childs = tables;

        File outFile = new ClassPathResource("outFile.docx").getFile();
        Document document = new Document();
        Section section = document.addSection();
        Paragraph paragraph = section.addParagraph();

        childs.forEach(cursor -> {
            CursorType type = cursor.getType();
            switch (type) {
                case STRING:
                    TextRange line = paragraph.appendText(cursor.getContent());
                    line.applyCharacterFormat(createFront(document));
                    break;
                case MATHML:
                    OfficeMath officeMath = new OfficeMath(document);
                    paragraph.getItems().add(officeMath);
                    officeMath.fromMathMLCode(cursor.getContent());
                    break;
                case IMAGE:
                    if (Objects.isNull(cursor.getImgBytes())) paragraph.appendText(cursor.getContent());
                    else {
                        List<byte[]> imgBytes = cursor.getImgBytes();
                        imgBytes.forEach(imgByte -> {
                            DocPicture picture = paragraph.appendPicture(imgByte);
                            picture.setHeight(200F);
                            picture.setWidth(240F);
                        });
                    }
                    break;
                default:
                    writeTable(paragraph.getDocument(), cursor);
                    break;
            }
        });

        document.saveToFile(new FileOutputStream(outFile), FileFormat.Docx_2013);
    }

    private static CharacterFormat createFront (Document document) {
        CharacterFormat cf = new CharacterFormat(document);
        cf.setFontName("Times New Roman");
        return cf;
    }

    private static void writeTable (Document document, Cursor cursor) {
        List<List<String>> rows = cursor.getTable();

        Section section = document.getLastSection();
        Table table = section.addTable(true);

        int rowSize = rows.size();
        int colSize = rows.get(0).size();
        table.resetCells(rowSize, colSize);

        IntStream.range(0, rowSize).forEach(rowIndex -> {
            TableRow row = table.getRows().get(rowIndex);
            List<String> cells = rows.get(rowIndex);
            IntStream.range(0, colSize).forEach(colIndex -> {
                TableCell cell = row.getCells().get(colIndex);
                String content = cells.get(colIndex);
                Paragraph cellParagraph = cell.addParagraph();
                cellParagraph.appendText(content);
            });
        });
    }
}
