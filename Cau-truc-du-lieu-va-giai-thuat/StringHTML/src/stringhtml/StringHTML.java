/*
 * Đề bài:
   Trong ngôn ngữ dựa trên thẻ như XML hoặc HTML , nội dung được đặt giữa thẻ bắt đầu và thẻ kết thúc như thế nào <tag>contents</tag>. Lưu ý rằng thẻ kết thúc tương ứng bắt đầu bằng a /.

Đưa ra một chuỗi văn bản bằng ngôn ngữ dựa trên thẻ, phân tích văn bản này và truy xuất nội dung được đính kèm trong chuỗi các thẻ được tổ chức tốt đáp ứng tiêu chí sau:

Tên của thẻ bắt đầu và kết thúc phải giống nhau. Mã HTML <h1>Hello World</h2>là không hợp lệ , vì văn bản bắt đầu với một h1thẻ và kết thúc với một tổ chức phi khớp h2thẻ.

Các thẻ có thể được lồng nhau, nhưng nội dung giữa các thẻ lồng nhau được coi là không hợp lệ . Ví dụ, trong <h1><a>contents</a>invalid</h1>, contentslà hợp lệ nhưng invalidlà không hợp lệ .

Thẻ có thể bao gồm bất kỳ ký tự có thể in.
 */
package stringhtml;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nguyễn Văn Hoàng
 */
public class StringHTML {

    /**
     * Đây là phần tôi tự giải.
     */
    
    /*
      Hướng giải hướng đến:
      1. Tìm thẻ mở, sau khi tìm thẻ mở tao có 2 th xảy ra:
        a, Tìm được 1 thẻ mở khác => đánh dấu lại vị trí thẻ mở đó.
        b, tìm được thẻ đóng của thẻ khác =>  tìm lại thẻ mở từ đầu.
        c, tìm được thẻ đóng tương ứng => lấy đoạn văn bản trong thẻ đóng và thẻ mở.
      2. tìm thẻ đóng bắt đầu từ đâu:
       a, Từ đầu mảng, khi ta duyệt find.group() => regex, pattern khác tìm thẻ đóng tương ứng.
         => khả năng có thể xẩy ra là vị trí thẻ đóng i < vị trí thẻ mở j (nhưng có thể khắc phục được).
         => Tuy khắc phục được nhưng không tối ưu => dùng mẹ 2 vòng for duyệt cho chuẩn, Nhưng có vấn đề
               là tìm thẻ mở đóng, như thế nào. 
            => kết hợp cả hai vào, regex thì tìm thẻ, for sẽ duyệt mảng.
       b, Từ sau vị trí tìm thấy thẻ mở => chịu, chưa nghĩ dùng regex thế nào. 
         +Ta có thể thực hiện bằng cách lấy lần lượt các thẻ nhưng lưu lại vị trí.
             -> Các trường hợp thi vẫn tương đương trong B1.
    */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String input = scan.nextLine();
            
           
                String regex = "(\\<(?<name>[^\\<\\>]+)\\>)";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(input);
                
                int start = 0; //vị trí bắt đầu lấy string trong thẻ html
                String name = ""; //lưu tên thẻ.
                
                //đánh dấu đã tìm thấy thẻ mở hay chưa. 
                //Mục đích là khi tìm thấy thẻ đóng phù hợp hay không phù hợp ta đều phải xét lại 
                // vid trí thẻ đóng từ đầu.
                boolean flag = false; 
                
                //thẻ xét xem chuỗi có nội dung nào hợp lệ hay không.
                boolean check = false;
                
                while(m.find()){
                    // tìm thẻ mở
                    if(m.group().charAt(1) != '/'){
                        
                        start = m.end();
                        
                        /*ta sẽ lưu tên thẻ đóng cần tìm, lý do vì sao không lưu tên thẻ mở:
                          1. Nếu không làm thẻ cách này, lúc tìm thấy thẻ mở ta sẽ phải subString(1), đây
                             có thể gây ra lỗi do đọ dài chuỗi bằng không <=> thẻ <>.                           
                        */
                        name = "/" + m.group("name");
                        flag = true;
                    }   
                    
                    //tìm thấy thẻ đóng.                    
                    if(m.group().charAt(1) == '/' && flag == true){
                        //thẻ đóng tương ứng.
                        if( m.group("name").equals(name)){
                            String value = input.substring(start, m.start());
                            
                            //chuỗi có length > 0 mới được coi là hợp lệ.
                            if(!value.isEmpty()){
                               System.out.println( value );
                               if(!check) check = true;
                            }   
                        }
                        
                        flag = false;
                    }
                            
                }   
                
                if(!check) System.out.println("None");
            
        }

    }
    
    
    //đây là phần lấy trên mạng. => đẳng cấp
    public static void layChuoi(String line){
       
            
            
            boolean matchFound = false;
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = r.matcher(line);

            while (m.find()) {
                System.out.println(m.group(2));
                matchFound = true;
            }
            if ( ! matchFound) {
                System.out.println("None");
            }
        
    }
    
}
