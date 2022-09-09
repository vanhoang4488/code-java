/*
 *Đề bài:
  Hai chuỗi, a và b , được gọi là đảo chữ cái nếu chúng chứa tất cả các ký tự giống nhau trong cùng tần số. Ví dụ, cách đảo chữ cái của CATlà CAT, ACT, TAC, TCA, ATC, và CTA.

Hoàn thành chức năng trong trình soạn thảo. Nếu a và b là các đảo chữ không phân biệt chữ hoa chữ thường, in "Anagrams"; mặt khác, in "Not Anagrams" thay vào đó.

Định dạng đầu vào
Độ dài a và b phải lớn hơn 0.
Dòng đầu tiên chứa một chuỗi biểu thị .
Dòng thứ hai chứa một chuỗi biểu thị.
 */
package anagrams;

import java.util.Scanner;

/**
 *
 * @author Nguyễn Văn Hoàng
 */
public class Anagrams {

    static boolean isAnagram(String a, String b) {
        //ktra gia tri a va b
        if(a == null || b == null || a.equals("") || b.equals(""))
           throw new IllegalArgumentException();

        //ktra độ dài a và b
        if(a.length() != b.length()) return false;

        
        java.util.Map<Character, Integer> map = new java.util.HashMap<>();
        
        for(int i = 0; i< b.length(); i++){
            char letter = b.charAt(i);

            if( !map.containsKey(letter) ){
                map.put(letter, 1);
            }else{
                Integer frequency = map.get(letter);
                map.put(letter, ++frequency);
            }

        }

        for(int i = 0; i< a.length(); i++){
            char letter = a.charAt(i);

            if( !map.containsKey(letter) ) return false;
            
            Integer frequency = map.get(letter);
            
            if(frequency == 0)
                return false;
            else
                map.put(letter, --frequency);
        }
        
        return true;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
    
}
