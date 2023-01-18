package com.os;

import org.apache.commons.codec.Resources;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTR;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

public class CreateOMMLFromMathML {

    /**
     * JAXP0801001: the compiler encountered an XPath expression containing '69' groups that exceeds the '10' limit set by 'FEATURE_SECURE_PROCESSING'.']
     * Đây là lỗi do Oracle đã giới hạn 1 số tham số mặc định:
     * 1. jdk.xml.xpathExprGrpLimit Mô tả: Giới hạn số lượng nhóm một biểu thức XPath có thể chứa. Mặc định 10.
     * 2. jdk.xml.xpathExprOpLimit Mô tả: Giới hạn số lượng toán tử một biểu thức XPath có thể chứa. Mặc định 100.
     * 3. jdk.xml.xpathTotalOpLimit Mô tả: Giới hạn tổng số Toán tử XPath trong Biểu định kiểu XSL. Mặc định 10000.
     *
     * Để khắc phục vấn đề này ta cần chạy chương trình java với các lệnh sau:
     * java -Djdk.xml.xpathExprGrpLimit=0 -Djdk.xml.xpathExprOpLimit=0 -Djdk.xml.xpathTotalOpLimit=0 -Xmx2g -Xms512m -XX:-UseGCOverheadLimit ....
     * @param mathML
     * @return
     * @throws Exception
     */
    static CTOMath getOMML (String mathML) throws Exception {
        StreamSource stylesource = new StreamSource(Resources.getInputStream("MML2OMML.XSL"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);

        StringReader stringReader = new StringReader(mathML);
        StreamSource source = new StreamSource(stringReader);

        StringWriter stringWriter = new StringWriter();
        StreamResult result = new StreamResult(stringWriter);
        transformer.transform(source, result);

        String ooML = stringWriter.toString();
        stringWriter.close();

        CTOMathPara ctoMathPara = CTOMathPara.Factory.parse(ooML);
        CTOMath ctoMath = ctoMathPara.getOMathArray(0);

        XmlCursor xmlCursor = ctoMath.newCursor();
        while (xmlCursor.hasNextToken()) {
            XmlCursor.TokenType tokenType = xmlCursor.toNextToken();
            if (tokenType.isStart() && xmlCursor.getObject() instanceof CTR) {
                CTR ctr = (CTR) xmlCursor.getObject();
                ctr.addNewRPr2().addNewRFonts().setAscii("Cambria Math");
                ctr.getRPr2().getRFonts().setHAnsi("Cambria Math");
            }
        }

        return ctoMath;
    }

    public static void main (String[] args) throws Exception {
//        XWPFDocument document = new XWPFDocument();
//
//        XWPFParagraph paragraph = document.createParagraph();
//        XWPFRun run = paragraph.createRun();
//        run.setText("The Pythagorean theoren: ");

        String mathML =
                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">"
                        +"<mrow>"
                        +"<msup><mi>a</mi><mn>2</mn></msup><mo>+</mo><msup><mi>b</mi><mn>2</mn></msup><mo>=</mo><msup><mi>c</mi><mn>2</mn></msup>"
                        +"</mrow>"
                        +"</math>";

        CTOMath ctoMath = getOMML(mathML);
        System.out.println(ctoMath);
//
//        CTP ctp = paragraph.getCTP();
//        ctp.setOMathArray(new CTOMath[]{ctoMath});
//
//        paragraph = document.createParagraph();
//        run = paragraph.createRun();
//        run.setText("The Quadratic Formula: ");
//
//        mathML =
//                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">"
//                        +"<mrow>"
//                        +"<mi>x</mi><mo>=</mo><mfrac><mrow><mrow><mo>-</mo><mi>b</mi></mrow><mo>±</mo><msqrt><mrow><msup><mi>b</mi><mn>2</mn></msup><mo>-</mo><mrow><mn>4</mn><mo>⁢</mo><mi>a</mi><mo>⁢</mo><mi>c</mi></mrow></mrow></msqrt></mrow><mrow><mn>2</mn><mo>⁢</mo><mi>a</mi></mrow></mfrac>"
//                        +"</mrow>"
//                        +"</math>";
//
//        ctoMath = getOMML(mathML);
//        System.out.println(ctoMath);
//
//        ctp = paragraph.getCTP();
//        ctp.setOMathArray(new CTOMath[]{ctoMath});
//
//        FileOutputStream out = new FileOutputStream("OMMLFromMathML.docx");
//        document.write(out);
//        out.close();
//        document.close();
    }
}
