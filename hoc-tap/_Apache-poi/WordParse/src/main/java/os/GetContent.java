package os;

import com.spire.doc.*;
import com.spire.doc.collections.DocumentObjectCollection;
import com.spire.doc.documents.DocumentObjectType;
import com.spire.doc.documents.Paragraph;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

public class GetContent {

    public static void main (String[] args) throws IOException {

        Document document = new Document();
        File file = new ClassPathResource("de_mau.docx").getFile();
        document.loadFromFile(file.getAbsolutePath());

        Section section = document.getLastSection();
        for (int i = 0; i < section.getBody().getChildObjects().getCount(); i++)
        {
            if (section.getBody().getChildObjects().get(i).getDocumentObjectType() == DocumentObjectType.Table)
            {
                Table table = (Table) section.getBody().getChildObjects().get(i);
                DocumentObjectCollection objects = table.getChildObjects(); //Includes "the "Contents" and the list in table of contents "
                for (int j = 0; j < objects.getCount(); j++) {
                    if (objects.get(j).getDocumentObjectType() == DocumentObjectType.Table_Row) {
                        TableRow row = (TableRow) objects.get(j);

                        DocumentObjectCollection rowObjects = row.getChildObjects();
                        for (int k = 0; k < rowObjects.getCount(); k++) {
                            if (rowObjects.get(k).getDocumentObjectType() == DocumentObjectType.Table_Cell) {

                                TableCell cell = (TableCell) rowObjects.get(k);
                                DocumentObjectCollection cellObjects = cell.getChildObjects();

                                for(int l = 0; l < cellObjects.getCount(); l++) {
                                    if (cellObjects.get(l).getDocumentObjectType() == DocumentObjectType.Paragraph) {
                                        Paragraph paragraph = (Paragraph) cellObjects.get(l);
                                        System.out.print(paragraph.getText() + " ");
                                    }
                                }
                            }
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
