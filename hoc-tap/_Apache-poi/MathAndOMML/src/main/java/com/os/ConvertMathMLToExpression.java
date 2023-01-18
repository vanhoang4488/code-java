package com.os;

import org.apache.commons.codec.Resources;
import org.apache.commons.lang3.StringEscapeUtils;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Scanner;


/**
 * Trước tiên, muốn chuyển đổi Mathml hay xml a sang xmlb hoặc định dạng văn bản
 * thì ta phải sử dụng ngôn ngữ xslt.
 * file ml2word.xslt là lấy trong thư viện của spire.doc phiển bản free
 * để cài đặt spire.doc bằng maven ta khai ba như sau
 * <dependencies>
 *      <dependency>
 *             <groupId>e-iceblue</groupId>
 *             <artifactId>spire.doc.free</artifactId>
 *             <version>5.2.0</version>
 *      </dependency>
 * </dependencies>
 *
 * <repositories>
 *         <repository>
 *             <id>com.e-iceblue</id>
 *             <name>e-iceblue</name>
 *             <url>https://repo.e-iceblue.com/nexus/content/groups/public/</url>
 *         </repository>
 *     </repositories>
 */
public class ConvertMathMLToExpression {

    public static void main (String[] args) throws Exception {
        String filename = "ml2word.xslt";
        StreamSource sourceFactory = new StreamSource(Resources.getInputStream(filename));

        Scanner sc = new Scanner(System.in);
        String input = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\" display=\"inline\"><mrow><mi>&nbsp;</mi><mi>y</mi><mo>=</mo><mi>a</mi><msup><mi>x</mi><mrow><mn>2</mn></mrow></msup><mo>+</mo><mi>b</mi><mi>x</mi><mo>+</mo><mi>c</mi><mo stretchy=\"false\">(</mo><mi>a</mi><mo>≠</mo><mn>0</mn><mo stretchy=\"false\">)</mo><mi>&nbsp;</mi></mrow></math>";
        //String input = sc.nextLine();
        //String input = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mrow><mover><mtext>CEF</mtext><mo>^</mo></mover></mrow><mo>=</mo><mi>φ</mi><mo stretchy=\"false\">⇒</mo><mrow><mover><mtext>AED</mtext><mo>^</mo></mover></mrow><mo>=</mo><mn>90</mn><msup><mrow>&nbsp;</mrow><mo>∘</mo></msup><mo>−</mo><mi>φ</mi></math>";
        //String input = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mi>A</mi><mi>C</mi><mo>=</mo><mstyle displaystyle=\"true\" scriptlevel=\"0\"><mfrac><mn>2</mn><mrow><mi>sin</mi><mo>\u2061</mo><mi>φ</mi></mrow></mfrac></mstyle><mo>+</mo><mstyle displaystyle=\"true\" scriptlevel=\"0\"><mfrac><mn>2</mn><mrow><mi>c</mi><mi>o</mi><mi>s</mi><mi>φ</mi></mrow></mfrac></mstyle><mo>≥</mo><mstyle displaystyle=\"true\" scriptlevel=\"0\"><mfrac><mn>8</mn><mrow><mi>sin</mi><mo>\u2061</mo><mi>φ</mi><mo>+</mo><mi>c</mi><mi>o</mi><mi>s</mi><mi>φ</mi></mrow></mfrac></mstyle><mo>≥</mo><mstyle displaystyle=\"true\" scriptlevel=\"0\"><mfrac><mn>8</mn><mrow><msqrt><mn>2</mn></msqrt><mi>sin</mi><mo>\u2061</mo><mrow><mo>(</mo><mrow><mi>φ</mi><mo>+</mo><mstyle displaystyle=\"true\" scriptlevel=\"0\"><mfrac><mi>π</mi><mn>4</mn></mfrac></mstyle></mrow><mo>)</mo></mrow></mrow></mfrac></mstyle><mo>≥</mo><mn>4</mn><msqrt><mn>2</mn></msqrt></math>";
        input = StringEscapeUtils.unescapeHtml4(input);
        System.out.println(input);

        StringReader reader = new StringReader(input);
        StreamSource source = new StreamSource(reader);

        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);

        Transformer transformer = TransformerFactory.newInstance().newTransformer(sourceFactory);

        transformer.transform(source, result);

        String xml = writer.toString();
        writer.close();

        System.out.println(xml);
    }
}
