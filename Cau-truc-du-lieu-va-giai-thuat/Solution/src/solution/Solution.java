package solution;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final String MATHML_START = "<math xmlns=";
    private static final String MATHML_END = "</math>";

    private static Pattern CHECK_MATHML = Pattern.compile("(?=.*\\<math xmlns=.*).*");

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String example = sc.nextLine();
       List<String> paragraphs = findSubString(example);
       display(paragraphs);
    }

    private static List<String> findSubString(String example) {
        List<String> paragraphs = new ArrayList<>();
        Matcher matcher = CHECK_MATHML.matcher(example);
        if(matcher.matches()) findAllMathML(paragraphs, example);
        return paragraphs;
    }

    private static void findAllMathML (List<String> paragraphs, String example) {
        int pos = findMathML(paragraphs, example);
        if (pos == 0) {
            paragraphs.add(example);
            return;
        }
        example = example.substring(pos);
        findAllMathML(paragraphs, example);
    }

    private static int findMathML (List<String> paragraphs, String example) {
        int start = example.indexOf(MATHML_START);
        int end = example.indexOf(MATHML_END);

        if (start > -1 && end > -1) {
            if(start > 0) paragraphs.add(example.substring(0, start));
            String subStr = example.substring(start, end+MATHML_END.length());
            paragraphs.add(subStr);
            return end + MATHML_END.length();
        }
        return 0;
    }

    private static void display (List<String> paragraphs) {
        paragraphs.forEach(System.out::println);
    }
}
