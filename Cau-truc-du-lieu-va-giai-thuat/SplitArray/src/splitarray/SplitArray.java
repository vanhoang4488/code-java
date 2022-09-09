/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitarray;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class SplitArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int sum = 0;
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
            sum+= arr[i];
        }
        
        int total = 0;
        int min = sum + 1;
        for(int i = 1; i < N - 2; i++){
             total = 0;
             for(int j = 0; j <= i; j++){
                total += arr[j];
             } 
             int min2 = total - (sum - total);
             if(min2 < 0) min2 = -min2;
             if(min2 < min) min = min2;
        }    
        
        System.out.println(min);
        
    }
    
}
