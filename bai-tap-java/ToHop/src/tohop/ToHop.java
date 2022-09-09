/*
 * Viết chương trình liệt kê tất cả các tập con k phần tử của 1, 2, ..,n (k≤n).
   (Tổ hợp chập k của n)
 */
package tohop;

import java.util.Scanner;

/**
 *
 * @author ABC
 */
public class ToHop {

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
    
    //tìm số tổ hợp chập k của n
    private int TimSoTH(int k, int n){
        if(k == 1){
           //ta có số tổ hợp bằng số n
           return n;
        } 
        else if(k == 0 || k == n){
           //ta có 1 tổ hợp là tập rỗng.
           return 1;
        }
        else{
            /*
            *Lý giải bài toán:
            *
            */
            return TimSoTH(k, n -1) + TimSoTH(k -1, n - 1);
        }
    }    
    
    
    //liệt kê số tố hợp chập k của n.
    //giải thích: https://www.youtube.com/watch?v=b4eYHnlN66s
    
    private void next(int i, int[] a, int n, int k){
        for(int j = a[i - 1] + 1; j <= n - k + i; j++){
            a[i] = j;
            if(i == k) {
                xuat(a, k);
            }else{
                next(i + 1, a, n, k);
            }
        }
    }
    
    private void xuat(int[] a, int k){
         for(int i = 1; i <= k; i++){      
               System.out.print(a[i] + " ");
         }    
         System.out.println();
    }
    
    public static void main(String[] args) {
        ToHop th = new ToHop();
        int k = th.nhap();
        int n = th.nhap();
        int[] a = new int[100];
        
        th.next(1, a, n, k);
    }
    
}
