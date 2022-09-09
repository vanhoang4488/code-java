/*
 * Đề bài: Dùng Regex để loại bỏ các từ lặp liền nhau và không phân biệt chữ hoa, chữ thường.
VD: I love Love to To to code.
=> ouput: i love to code.

 */
package regexlaptu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nguyễn Văn Hoàng
 */
public class RegexLapTu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
          giải thích regex: 
          +> ?: là nhóm trong ngoặc có thể xuất hiện có hoặc không.
          +> \\1 so trùng với nhóm trong ngoặc đầu tiện và đồng thời đánh dấu index 
            trong m.group() ở vị trí 1. Ở đây so trùng với \w+.
        */
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        
        while (numSentences-- > 0) {
            String input = in.nextLine();
            
            Matcher m = p.matcher(input);
            
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
               // System.out.println(m.group() + " " + m.start(0) + " " + m.end(1));
              input = input.replaceAll(m.group(), m.group(1));
                
            }
            
            // Prints the modified sentence.
            System.out.println(input);
        }
        
        in.close();
    }
    
}
