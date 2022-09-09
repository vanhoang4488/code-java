/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oquan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Nguyen Van Hoang
 */
public class TestCase {
    
    
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private int max = 0;
    private int count = 0;
    public TestCase(){
        
        for(int i = 0; i< 12; i++){
            
            int value = sc.nextInt();
            
            
            list.add(value);
            
            
        }   
        
        
    }
    
    
    private int checkPos(int pos){
        
        if(pos > 11){
            
            pos = pos - 12;
        }
        
        return pos;
        
    }
    
    //ở đây mình cần 1 giá trị trả về để xác định  xem có lên gieo tiếp không
    // Xác định giá trị trả về là vị trí ô tiếp theo
    /*
    *
    *
    trường hợp cho gieo tiếp là ô tiếp theo không phải 5 và 11 và giá trị ô tiếp theo phải lớn > 0;
    trường hợp ô tiếp theo = 0 nhưng ở vị trí khác 5  và 11 thì làm gì?
    => trả lời: nhiều vướng mắc và khó giải quyết
    => ở phần gieo 1 lần chỉ lên trả về vị trí tiếp theo, phần xử lí giao cho gieo liên tiếp.
    
    */
    private int  gieoMotLan(ArrayList<Integer> arr, int a){
 
        int nextPos = checkPos(list.get(a) + a + 1); 
        
        int start = checkPos(a  + 1);
        
        
        int end = checkPos(a + arr.get(a));
        
        while(true){
     
            int value = arr.get(start) + 1;
                  
                  
            arr.remove(start);
                  
                  
            arr.add(start, value);
            
            
            if(start == end) break;
          
            start ++;
            
            if( start == 12){
                
               start = 0; 
            }
            
        }
                
           
        
        arr.remove(a);
            
            
        arr.add(a, 0);
      
        
        return nextPos;
    }
    
    private void gieoLt(ArrayList<Integer> arr, int a){
       
        
        
        int pos = gieoMotLan(arr, a);
        
        if(pos == 5 || pos == 11)
               return ;
        
        if(arr.get(pos)  == 0){
             int value = tinhMax(arr, pos);
             
             
             if( value > max) max = value;
             
          
             return;
        }
        
        
        gieoLt(arr, pos);
        
    }
    
    private int tinhMax(ArrayList<Integer> arr, int pos){
        int value = 0;
        
        while(true){
            
            int val = arr.get(pos);
            
            int nextVal = arr.get(checkPos(pos + 1));
            
            
            if(val != 0 || nextVal == 0) break;
            
            value += nextVal;
            
            pos = checkPos(pos + 2);
            
        }
         
        
        
        return value;
        
        
        
    }
    
    private void gieoThuan(){
     
        
        for(int a = 0; a < 12; a++){
            
            if(list.get(a)  == 0) continue;
            
            
            
            
            ArrayList<Integer> arr = new ArrayList<Integer>(list);
            
            
            
            gieoLt(arr, a);
            
            
              
        }
        
        
       
    }

    private void gieoNguoc(){
        
        Collections.reverse(list);
        
        for(int a = 0; a < 12; a++){
            
            
           
            if(list.get(a)  == 0) continue;
            
            ArrayList<Integer> arr = new ArrayList<Integer>(list);
            
            
            gieoLt(arr, a);
            
            
            
        }
        
    }
    
    
    public void gieo(){
        
        gieoThuan();
        
        gieoNguoc();
        
        
    }
    
    
    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
     
    
    public void In(){
        
        for(int i = 0; i< 12; i++){
            System.out.print(list.get(i) + " ");
            
        }
        
        System.out.println();
        
    }
    
    
    public void In(ArrayList<Integer> arr){
        
        for(int i = 0; i< 12; i++){
            System.out.print(arr.get(i) + " ");
            
        }
        
        System.out.println();
        
    }
}
