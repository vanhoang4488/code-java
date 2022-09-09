/*
 * Viết chương trình chuyển đổi một số tự nhiên ở hệ cơ số 10 thành số ở hệ cơ số b bất kì (1< b≤ 36).
 */
package chuyendoihecs;

import java.util.Scanner;

/**
 *
 * @author ABC
 */
public class ChuyenDoiHeCS {

    private int nhap(){
       Scanner sc = new Scanner(System.in);
       int a = 0;
       System.out.print("Nhap so tu nhien: ");
       while(a <= 0){
           a = sc.nextInt();
           if(a <= 0) System.out.print("Nhap lai so tu nhien:");
       }    
       return a;
    }
    
    private String CHCS(int a, int b){ //tự bản thân làm
        String hcs = "";
        int c = 0;
        while(a > 0){
             c = a % b;
             a = a / b;
             hcs = ((c < 10)?String.valueOf(c):Character.toString((char) ( c + 55))) + hcs;
        }    
        return hcs;
    }
    
    public static void main(String[] args) {
        ChuyenDoiHeCS cd = new ChuyenDoiHeCS();
        int a = cd.nhap();
        int b = cd.nhap();
        
        System.out.println("Chuyen doi he co so: " + cd.CHCS(a, b));
        cd.doiCoSo(a, b);
    }
    private void doiCoSo(int n,int base){ //tìm trên mạng
     if(n>=base) doiCoSo(n / base, base);
       if(n % base>9) System.out.printf("%c",n%base+55); 
      else
      System.out.print((n % base));
  }
}
