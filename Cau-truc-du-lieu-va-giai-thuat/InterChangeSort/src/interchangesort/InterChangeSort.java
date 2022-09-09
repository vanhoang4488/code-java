/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interchangesort;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class InterChangeSort {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n; i++) arr[i] = scan.nextInt();
        
        for(int i = 0; i < n - 1; i++)
            for(int j = i + 1; j < n; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        
        for(int i = 0; i < n; i++) System.out.print(arr[i] + " ");
    }
    
}
