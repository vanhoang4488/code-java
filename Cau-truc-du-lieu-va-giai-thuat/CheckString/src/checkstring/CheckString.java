/*
 *Đề bài:
 Một chuỗi chỉ chứa các dấu ngoặc đơn được cân bằng nếu sau đây là đúng: 1. nếu đó là một chuỗi rỗng 2. nếu A và B đúng, AB đúng, 3. nếu A đúng, (A) và {A} và [ A] cũng đúng.

Ví dụ về một số chuỗi cân bằng chính xác là: "{} ()", "[{()}]", "({()})"

Ví dụ về một số chuỗi không cân bằng là: "{} (", "({)}", "[[", "} {", v.v.

Đưa ra một chuỗi, xác định xem nó có cân bằng hay không.
 */
package checkstring;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Nguyễn Văn Hoàng
 */
public class CheckString {

    /**
     * @param args the command line arguments
     */
    public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);       

		while (sc.hasNext()) {
			String input=sc.next();
            System.out.println(checkString(input));         
		}
		
	}
   
    //tự làm
    public static boolean checkString(String s){
        if(s.isEmpty()) return true;
        Stack st = new Stack();
        for(int i = 0; i< s.length(); i++){
            char let = s.charAt(i);
            if( Character.toString(let).matches("[^\\(\\)\\[\\]\\{\\}]") ) continue;
            if(st.empty()){ 
              st.push(let);
            }else{
                char let2 = (Character) st.peek();
                
                switch(let){
                    case ']':
                         if(let2 != '[') return false;
                         st.pop();
                         break;
                    case ')':  
                         if(let2 != '(') return false;
                         st.pop();
                         break;
                    case '}':
                         if(let2 != '{') return false;
                         st.pop();
                         break;
                    default:
                        st.push(let);
                 }
                
               
            }  
        }
        if(!st.empty()) return false;
        return true;
    }
    
    
    //lấy trên mạng có thể xử lý cả trường hợp có dữ liêu trong ngoặc.
    public static void check(String input){
    input=input.replaceAll("[^\\(\\)\\[\\]\\{\\}]", "");
    /*
      Giải thích:
      - ở đây ta thực hiên thay thế các ngoặc gần nhau bằng "".
    */
    while(input.length() != (input = input.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length());
    System.out.println(input.isEmpty());
    }
}
