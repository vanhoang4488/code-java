package jar;
import org.apache.commons.lang3.StringUtils;
public class App 
{
    public static void main( String[] args )
    {
        String text1 = "1234a";
        String text2 = "1234";
        
        boolean check1 = StringUtils.isNumeric(text1);
        boolean check2 = StringUtils.isNumeric(text2);
        
        System.out.println(check1);
        System.out.println(check2);
    }
}
