/*
 * Bài 3. Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ. Ví dụ: Số 8545604 có tổng các chữ số là: 8+5+4+5+6+0+4= 32.
 */
package tongcs;
import java.util.Scanner;
/**
 *
 * @author ABC
 */
public class TongCS {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TongCS tt = new TongCS();
        int a = sc.nextInt();
        System.out.println("Tong cac chu so la:" + tt.Tong(a));
        System.out.println("Tong cac chu so la:" + tt.Total(a));
    }
    
    private int Tong(int a){//tự làm
       int total = 0;
       String Sa = String.valueOf(a);
       for(int i =0; i < Sa.length(); i++){
           total += Integer.parseInt( Character.toString(Sa.charAt(i)) );
       }
       
       return total; 
    }    
    
    private int Total(int a){ //tìm kiếm trên mạng
         int sum = 0;
         while( a != 0){
             sum += (a % 10);
             a = a / 10;
         }
         return sum;
    }    
    
}
