/*
 * Bài 7: Viết phương trình tìm số Fibonacci thứ n.
 */
package fibonacci;

import java.util.Scanner;

/**
 *
 * @author ABC
 */
public class Fibonacci {
    private int so;
    
    private int nhap(){
        Scanner sc = new Scanner(System.in);
        int a = -1;
        while(a < 0){
            try{
                System.out.print("Nhap so tu nhien: ");
                a = sc.nextInt();
                if(a < 0) System.out.println("ban da nhap sai! Vui long nhap lai....");
            }catch(Exception e){
                System.out.println("ban da nhap sai! Vui long nhap lai....");
                sc.nextLine();
            }
        }
        return a;
    }
    
    private int TinhFibo(int i){
       if(i == 0 || i == 1) return 1;
    
       return so + TinhFibo(i - 1) + TinhFibo(i - 2);    
    }
    
    public static void main(String[] args) {
        
        Fibonacci fi = new Fibonacci();
        int n = fi.nhap();
        System.out.println("So Fibonacci thu " + n + " la: " +fi.TinhFibo(n) );
    }
    
}
