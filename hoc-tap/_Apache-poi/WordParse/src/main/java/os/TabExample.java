package os;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.Section;
import com.spire.doc.Tab;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.TabJustification;
import com.spire.doc.documents.TabLeader;

public class TabExample {

    public static void main (String[] args) {
        Document document = new Document();
        //Add a section
        Section section = document.addSection();
        //Add paragraph 1
        Paragraph paragraph1 = section.addParagraph();
        //Add tab and set its position (in points)
        Tab tab = paragraph1.getFormat().getTabs().addTab(28);
        //Set tab alignment
        tab.setJustification(TabJustification.Left);
        //move to next tab and append text
        paragraph1.appendText("\tWashing Machine");
        //Add another tab and set its position (in points)
        tab = paragraph1.getFormat().getTabs().addTab(280);
        //Set tab alignment
        tab.setJustification(TabJustification.Left);
        //Specify tab leader type
        tab.setTabLeader(TabLeader.Dotted);
        //move to next tab and append text
        paragraph1.appendText("\t$650");
        //Add paragraph 2
        Paragraph paragraph2 = section.addParagraph();
        //Add tab and set its position (in points)
        tab = paragraph2.getFormat().getTabs().addTab(28);
        //Set tab alignment
        tab.setJustification(TabJustification.Left);
        //move to next tab and append text
        paragraph2.appendText("\tRefrigerator"); //move to next tab and append text
        //Add another tab and set its position (in points)
        tab = paragraph2.getFormat().getTabs().addTab(280);
        //Set tab alignment
        tab.setJustification(TabJustification.Left);
        //Specify tab leader type
        tab.setTabLeader(TabLeader.No_Leader);
        //move to next tab and append text
        paragraph2.appendText("\t$800");
        //Save and close the document object
        document.saveToFile("Tab.docx", FileFormat.Docx_2010);
        document.close();
    }
}
