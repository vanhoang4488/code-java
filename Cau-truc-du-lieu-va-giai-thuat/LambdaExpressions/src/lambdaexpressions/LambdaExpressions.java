/*
 * ĐỀ bài:
thử thách Java 8 này kiểm tra kiến ​​thức của bạn về các biểu thức Lambda !

Viết các phương thức sau đây trả về một biểu thức lambda thực hiện một hành động được chỉ định:

1.PerformanceOperation isOdd (): Biểu thức lambda phải trả về true nếu một số là số lẻ hoặc false nếu nó là chẵn
2.PerformanceOperation isPrime (): Biểu thức lambda phải trả về true nếu một số là số nguyên tố hoặc false nếu nó là composite.
3.PerformanceOperation isPalindrome (): Biểu thức lambda phải trả về true nếu một số là có số nghịch đảo tương đương hoặc false khi ngược lại.
Định dạng đầu vào

Đầu vào được xử lý cho bạn bởi mã gốc bị khóa trong trình chỉnh sửa của bạn.

Định dạng đầu ra

Mã sơ khai bị khóa trong trình chỉnh sửa của bạn sẽ in T dòng đầu ra.

Đầu vào mẫu

Dòng đầu tiên chứa một số nguyên, T (số lượng các trường hợp thử nghiệm).

Các  mỗi dòng tiếp theo mô tả một trường hợp thử nghiệm ở dạng số nguyên được phân tách bằng dấu cách:
Số nguyên đầu tiên chỉ định điều kiện để kiểm tra ( 1cho lẻ / chẵn  2cho số nguyên tố, hoặc 3 cho Palindrom). Số nguyên thứ hai biểu thị số cần kiểm tra.
 */
package lambdaexpressions;

import java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
 public static boolean checker(PerformOperation p, int num) {
  return p.check(num);
 }

    public PerformOperation isOdd(){
        return new PerformOperation(){
            public boolean check(int n){
                return (n%2==0)?false:true;
            }
        };
    }

    public PerformOperation isPrime(){
        return new PerformOperation(){
            public boolean check(int n){
                if(n < 2) return false;
                else if(n == 2) return true;
                else if( n % 2 == 0) return false;

                int sqrt = (int) Math.sqrt(n);
                for(int i = 3; i <= sqrt; i++)
                   if(n % i == 0) return false;
                return true;   
            }
        };
    }

    public PerformOperation isPalindrome(){
        return new PerformOperation(){
            public boolean check(int n){
                System.out.println(n + " " + new StringBuilder(n).reverse().toString() + " ?????");
                return (String.valueOf(n).equals(new StringBuilder(n).reverse().toString()))?false:true;
            }
        };
    }

    
}


public class LambdaExpressions {

 public static void main(String[] args) throws IOException {
  MyMath ob = new MyMath();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int T = Integer.parseInt(br.readLine());
  PerformOperation op;
  boolean ret = false;
  String ans = null;
  while (T--> 0) {
   String s = br.readLine().trim();
   StringTokenizer st = new StringTokenizer(s);
   int ch = Integer.parseInt(st.nextToken());
   int num = Integer.parseInt(st.nextToken());
   if (ch == 1) {
    op = ob.isOdd();
    ret = ob.checker(op, num);
    ans = (ret) ? "ODD" : "EVEN";
   } else if (ch == 2) {
    op = ob.isPrime();
    ret = ob.checker(op, num);
    ans = (ret) ? "PRIME" : "COMPOSITE";
   } else if (ch == 3) {
    op = ob.isPalindrome();
    ret = ob.checker(op, num);
    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

   }
   System.out.println(ans);
  }
 }
}
