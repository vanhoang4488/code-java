/*
 * Bài 11. Viết chương trình liệt kê tất cả các hoán vị của 1, 2, .., n. 
 */


/*
 ý tưởng:
  Xuất phát từ phần tử thứ n - 1 lùi về đầu dãy.
  Tìm phần tử a[i] đầu tiên sao cho a[i] < a[i+1].
  Sau đó kiểm tra lại nếu i > 0 thì thực hiện :
        - Kiểm tra từ cuối dãy lên đầu , tìm phần tử đầu tiên lớn hơn a[i].
          đổi chỗ a[i] và phần tử này.
        - Đảo ngược vị trí các phần tử từ a[i] tới a[n].
  Nếu i = 0 kết thức chương trình. 
*/
package hoanvi;

import java.util.Scanner;

/**
 *
 * @author ABC
 */
public class HoanVi {
    private boolean check = true;
    
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
    
    private void sinh(int n, int[] arr){
        int i = n - 1;
        while( i > 0 && arr[i] > arr[i+1]) i--;
        if(i > 0){
           int k  = n;
           while(arr[i] > arr[k]) k--;
           int t = arr[i]; arr[i] = arr[k]; arr[k] = t;
           int r = i + 1, s = n;
           while(r <= s){
               int tg = arr[r];
               arr[r] = arr[s];
               arr[s] = tg;
               r++; s--;
           }    
        }else {
            check = false;
        }    
    }
    
    private void LietKeHV(int n, int[] arr){
         while(check){       
              xuat(n, arr);
              sinh(n, arr);
         }    
    }    
    
    private void xuat(int n, int[] arr){
        for(int i = 1; i <= n; i++){
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        HoanVi hv = new HoanVi();
        int n = hv.nhap();
        
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
              arr[i] = i;
        }    
        
        hv.LietKeHV(n, arr);
    }
    
}
