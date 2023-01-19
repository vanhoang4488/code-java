package os;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MathMLParser {

    private static final String MATHML_START = "<math xmlns=";
    private static final String MATHML_END = "</math>";

    private static Pattern CHECK_MATHML = Pattern.compile("(?=.*<math xmlns=.*).*");

    private MathMLParser() {}

    public static List<Cursor> getMathMLs (List<Cursor> cursors) {
        List<Cursor> omaths = new ArrayList<>();
        cursors.forEach(cursor -> {
            if(CursorType.STRING.equals(cursor.getType())) {
                Matcher matcher = CHECK_MATHML.matcher(cursor.getContent());
                if(matcher.matches())
                    findAllMathML(omaths, cursor.getContent());
                else
                    omaths.add(cursor);
            }
            else omaths.add(cursor);
        });

        return omaths;
    }

    private static void findAllMathML (List<Cursor> omaths, String str) {
        int pos = findMathML(omaths, str);
        if (pos == 0) {
            omaths.add(new Cursor(CursorType.STRING, str));
            return;
        }
        str = str.substring(pos);
        findAllMathML(omaths, str);
    }

    private static int findMathML (List<Cursor> omaths, String str) {
        int start = str.indexOf(MATHML_START);
        int end = str.indexOf(MATHML_END);

        if (start > -1 && end > -1) {
            if(start > 0) omaths.add(new Cursor(CursorType.STRING, str.substring(0, start)));
            String subStr = str.substring(start, end+MATHML_END.length());
            omaths.add(new Cursor(CursorType.MATHML, subStr));
            return end + MATHML_END.length();
        }
        return 0;
    }
}
