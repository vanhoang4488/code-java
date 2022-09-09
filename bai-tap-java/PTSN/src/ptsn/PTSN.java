/*
 *Bài 4. Viết chương trình phân tích một số nguyên thành các thừa số nguyên tố 
 */
package ptsn;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ABC
 */
public class PTSN {
    /*
     tự làm
    */
    private int nhap(){
        Scanner sc = new Scanner(System.in);
        int a = 0;
        while(true){
            try{
                System.out.print("Nhap so nguyen: ");
                a = sc.nextInt();
                break;
            }catch(Exception e){
                System.out.println("ban da nhap sai! Vui long nhap lai....");
                sc.nextLine();
            }
        }
        return a;
    }
    
    //xử lý lấy số nguyên tố nhỏ hơn 1 số cho trước
    private void TimSoNT(int n, ArrayList<Integer> arr){
        
        for(int i = 2; i < n; i++){
            arr.add(i);
        }   
        
        //tìm số nguyên tố bằng các loại bỏ dần dần
        for(int i = 0; i <= arr.size(); i++){
            for(int j = i + 1; j < arr.size(); j++){
               if( (arr.get(j)) % (arr.get(i)) == 0 ) arr.remove(j);
            }
        }
        
    }
    
    //phân tích số thành tích các sô nguyên tố.
    private void PTTSN(ArrayList<Integer> arr, int n){
        int i = 0; 
        System.out.print("So nguyen " +n + " phan tich thanh: ");
        int sum = 1;
        while(sum < n){
            
            //Ghi nhớ số nguyên tố là số chỉ chia hết cho chính nó và 1; 
            //vì vây: khi tìn được ước số nguyên tố của n, ta không cần xét đến
            //việc tách nó ra, và kiểm tra xem nó là tích của các số nguyên tố nào.
            if( n % arr.get(i) == 0){ 
              if(sum * arr.get(i) <= n) {
                  System.out.print(arr.get(i));
                  sum = sum * arr.get(i);
              }              
              if(sum < n) System.out.print(" x ");
            }           
                        
            i++;
            if(i == arr.size()) i = 0;
            
            
        }
        
        System.out.println();
    }
    /*
    Tự làm
    */
    
    /*
       Lời giải trên mạng
    */
    private  boolean checkNguyenTo(int n){
  if(n <=2){
   return true;
  }else{
   for(int i = 2; i<=Math.sqrt(n);i++){
    if(n%i == 0){
     return false;
    }
   }
  }
  return true;
 }
 private void phantichthuasonguyento(int n){
    for(int i=2;i<=n;i++){
   while(checkNguyenTo(i) && (n%i ==0)){
    System.out.print(" "+i);
    n/=i;
   }
  }
 }
    
    /*
       Lời giải trên mạng
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PTSN pt = new PTSN();
        int n = pt.nhap();
        /*
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        pt.TimSoNT(n, arr);
        
        
        pt.PTTSN(arr, n);
        */
        pt.phantichthuasonguyento(n);
    }
    
}
