package paltform.ctv.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionUtil {

    public static String textByImageScan(String info){

        String regex = "\\$.*\\$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(info);
        while(matcher.find()){
            return matcher.group();
        }
        return null;
    }
}
