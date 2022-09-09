/*
 * Bài 9. Viết chương trình liệt kê tất cả các xâu nhị phân độ dài n.
 */
package xaunhiphan;

import java.util.Scanner;

/**
 *
 * @author ABC
 */
public class XauNhiPhan {

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
    /*
       Phần tự làm
    */
    
    //tinh so nhi phan co do dai n lon nhat sang he co so 10
    private int TinhSo(int n){
        int sum = 0;
        while(n >=0){
            sum += Math.pow(2, n);
            n--;
        }
        
        return sum;
    }    
    
    //chuyen he co so 10 sang nhi phan
    private String ChuyenCS(int n){
        String xau = "";
        while(n > 0){
            xau = ( String.valueOf((n % 2)) ) + xau;
            n/=2;
        }
        return xau;
    }
    
    private void DSXauNhiPhan(int n){
        int length = TinhSo(n);
        for(int i = 0; i <= length; i++){
            if(i == 0) {System.out.printf("%0" + (n + 1) + "d", 0);}
            else{System.out.printf("%0" + (n + 1) + "d", Integer.parseInt(ChuyenCS(i)));}
            System.out.print(" ");
        }
    }
    /*
      Phần tự làm
    */
    
    /*
       Phần lời giải trên mạng
    */
        
    /*
       Phần lời giải trên mạng
    */
    
    public static void main(String[] args) {
        XauNhiPhan xau = new XauNhiPhan();
        int n = xau.nhap();
        xau.DSXauNhiPhan(n);
    }
    
}
