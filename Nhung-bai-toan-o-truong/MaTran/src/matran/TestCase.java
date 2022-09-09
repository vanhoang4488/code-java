/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matran;

import java.util.Scanner;

/**
 *
 * @author Nguyen Van Hoang
 */
public class TestCase {
    
    private int[][] arr;
    private int n;
    private int m;
    private int amount;
    private int end;
    
    
    public TestCase(){
        
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        
        m = sc.nextInt();
        
        arr = new int[n][m];
        
        for(int x = 0; x < n; x++){
            
            for(int y = 0; y < m; y++){
                               
              arr[x][y] = sc.nextInt();
                
            }
            
        }
        
    }
    
    /*
    *
    *
    làm rõ vấn đề: là hình vuông được bao quanh bởi dãy số không
    hình vuông có kích thước 2 x 2 -> 5 x 5 => kích thước dãy số không bao quanh là 3x3 -> 6x6
    các hình vuông bao quanh bởi ít nhất 1 dãy số 0 => có thể có 2 hoặc nhiều hơn 2 dãy số không bao quanh.
    => timg hình vuông theo cụm 1
    => làm hai trượng hợp thuận và nghịch hai cái
    => thuận kết thúc ở vị trí end, nghịch bắt đầu ở vị trí end + 1;
    B1: Tạo mảng n x m;
    B2: vẽ 1 mảng hình vuông theo kiểu
    1 1 1 1 1 1
    1 2 2 2 2 2
    1 2 3 3 3 3
    1 2 3 4 4 4
    1 2 3 4 5 5
    1 2 3 4 5 5
    B3: tìm số lượng hình vuông bắt đầu từ vị trí 0;
    B2: làm với trường hợp chung chung 2 x 2 -> 5 x 5;
    B3: làm vơi trường hợp ở biên.
    
    
    */
    
    
    
    private void setEnd(){
        
        for(int y = 0; y < m; y++)
            if(arr[0][y] == 0){
                
                end = y;
                
                break;
            }
        
    }
    
    
    public  void getAmount(){
        
        
        
        
    }
    
    
    public void amountVuong(){
        
        //lựa chọn vị trí bắt đầu tìm kiếm
        // ta tìm số lượng hình vuông bắt đầu từ vị trí tìm kiếm.
        for(int x = 0; x < 1; x++){
            
            //giờ ta duyệt trên cột
            //đến khi xuất hiện số 0 thì thôi
        
        }    
                
        
    }
    
    public void veHinh(){
        
        for(int i = 0; i< 6; i++){
            
            for(int j = 0; j < 6 ; j++ ){
                
                
                if( j >= i){
                    
                  if( i < 5){
                      
                     System.out.print(1 + i + " ");    
                  
                  }else{
                      
                     System.out.print(i + " ");
                  }  
                  
                  
                }else{
                   System.out.print(j + 1 + " "); 
                }
                
                
                
            }
            
            System.out.println();
                
        }
         
    }
    
    
    public void In(){
        
       for(int x = 0; x < n; x++){
           
           for(int y = 0; y < m; y++){
               
               System.out.print(arr[x][y] + " ");
               
           }
           
           System.out.println();
       }
    }
}
