/*
 * Thuật toán tìm kiếm nhị phân
 */
package binarysearch;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class BinarySearch {

    private static int binarySearch(int[] arr, int so){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            
            if(arr[mid] < so ) left = mid + 1;
            
            if(arr[mid] > so ) right = mid - 1;
            
            if(arr[mid] == so) return mid;
        }
        
        return -1;
    }
    
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
        
        //số cần tìm
        int so = scan.nextInt();
        
        System.out.println( binarySearch(arr, so) ) ;
    }
    
}
