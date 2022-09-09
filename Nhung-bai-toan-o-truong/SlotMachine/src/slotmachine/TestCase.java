/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import java.util.Scanner;

/**
 *
 * @author Nguyen Van Hoang
 */
public class TestCase {
    
    private Scanner sc = new Scanner(System.in);
    private int[][] arr = new int[7][3];
    
    public TestCase(){
        
        
        for(int x = 0; x < 7; x++){
            
            for(int y = 0; y < 3; y++){
                
                arr[x][y] = sc.nextInt();
                
            }
            
        }
        
    }
    
   //B1:tính giá trị ở 3 hàng giữa
    
    //B2 : tính giá trị 3 hàng giữa khi thay đổi cột 1;
    
    //B3 : tính giá trị 3 hàng giữa khi thay đổi 1 trong 3 cột
    private int getMaxRow(int row, int col){
        int max = 0;
        
        
        for(int x = 2; x < 5; x++){           
            
            int value = 0;
            switch(col){
                case 0: 
                     if(arr[row][0] == 7 && arr[x][1] == 7 && arr[x][2] == 7){                                
                 
                         value = 100; 
                        
                     } else if(arr[row][0] == arr[x][1] && arr[x][1] == arr[x][2]){
                
                        value = arr[row][0] * 10;
                
                     } else{
                
                        value = arr[row][0] + arr[x][1] + arr[x][2];
                
                     }
                     break;
                case 1:
                    if(arr[x][0] == 7 && arr[row][1] == 7 && arr[x][2] == 7){ 
                                 
                        value = 100;            
            
                    } else if(arr[x][0] == arr[row][1] && arr[x][1] == arr[x][2]){
                
                        value = arr[x][0] * 10;
                
                    } else{
                
                       value = arr[x][0] + arr[row][1] + arr[x][2];
                
                    }
                    break;
                case 2:
                    if(arr[row][0] == 7 && arr[x][1] == 7 && arr[x][2] == 7){                  
               
                        value = 100; 
                        
                    } else if(arr[row][0] == arr[x][1] && arr[x][1] == arr[x][2]){
                
                        value = arr[row][0] * 10;
                
                    } else{
                
                        value = arr[row][0] + arr[x][1] + arr[x][2];
                
                    }
                    break;        
           }
            
            
            
            max += value;
            
            row ++;
        }
        
        return max;
    }    
    
    
    public void getMax(){
        
        
        int max = 0;
        
        
        //cột      
        for(int y = 0; y < 3; y++){
            
            //hàng
            
            for(int x = 0; x < 5; x ++){
                
                int value = getMaxRow(x, y);
                
                
                if( value > max) max = value;
            }
            
        }
               
        
         System.out.println("Max = " + max);
    }
    
    public void In(){
        
        for(int x = 0; x < 7; x++){
            for(int y =0; y < 3; y++){
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }    
        
    }
    
}
