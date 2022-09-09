/*
 * Đề bài: XÁC định độ khó của chuỗi String.
   Đầu vào: N số nguyên của mảng String[N].
   Xác định độ khó của từng chuỗi bằng cách:
    ---Một từ được coi là từ khó nếu:
           +> Từ đó có chữ cái khó lớn hơn số chữ cái không khó.
           +> Từ đó có số chữ cái khó liên tiếp lớn hơn 4.
           +> Chữ cái dược coi là khó nếu là chữ cái nguyên âm.
    ---Độ khó = 5*số từ khó + 3* số từ không khó.
 */
package sentence;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hoang
 */
public class Sentence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int n = Integer.parseInt(in.nextLine());
       for(int i = 0; i < n; i++){
           String s = (in.nextLine()).trim();
           if(s.isEmpty()) System.out.println("0");
           else{
               String[] arr = s.split("\\s+");
               doKho(arr);
           }
          
       }    
    }
    
    public static void doKho(String[] arr){
        int soTuKho = 0;
        for(int i = 0; i < arr.length; i++){
            if(xacDinhTuKho(arr[i])) soTuKho++;
        }
        System.out.println( (5*soTuKho + 3*(arr.length - soTuKho)));
    }
    
    
    public static boolean xacDinhTuKho(String s){
        String regex = ".*[aouei]{3}.*|.?[aouei]{1,2}.?";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        return m.matches();
    }
}
