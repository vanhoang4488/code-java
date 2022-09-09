/*
 * Sắp xếp nổi bọt.
 */
package bubblesort;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class BubbleSort {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = n - 1; j > i; j--){
                
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                
            }
        
        for(int i = 0; i < n; i++) System.out.print(arr[i] + " ");
    }
    
}
