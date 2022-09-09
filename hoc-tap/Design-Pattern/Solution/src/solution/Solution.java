/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Solution {

    public static void main(String[] args) {
        
       Scanner input = new Scanner(System.in);
       
       int n = input.nextInt();
       
       int[] arr = new int[n];
       
       for(int i = 0; i < n; i++) arr[i] = input.nextInt();
       
       int max = 0;
       int start = 0; int end = 0;
       int[] b = null;
       int pos = 0;
       
       for(int i = 1; i < n; i++){
           
           if(arr[i] == arr[i-1]){
               end++;
               
               if(end - start > max){
                   b = new int[n];
                   pos = 0;
                   max = end - start;
               }
               
               if(end - start == max ) {
                   b[pos++] = arr[i];
               }
           }
           else start = end = i;
       }
       
       for(int i = 0; i < pos; i++)
           System.out.println(b[i]);
    }
}