/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Scanner;

/**
 *
 * @author Nguyễn Văn Hoàng
 */
public class MergeSort {

    // học trên Youtube.
    private static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right){
       
        int i = left;
        int j = mid + 1;
        int k = 0;
        int n = right - left + 1;
        int[] arr2 = new int[n];
        
        while((i <= mid) && (j <= right)){
            if(arr[i] <= arr[j]){
                arr2[k] = arr[i];
                k++; i++;
            }else{
                arr2[k] = arr[j];
                k++; j++;
            }
        }
        
        while(i <= mid){
            arr2[k] = arr[i];
            k++;i++;
        }
        
        while(j <= right){
            arr2[k] = arr[j];
            k++;j++;
        }
        
        for(int x  = right; x >= left; x--){
            k--;
            arr[x] = arr2[k];
        }
    }
    //học trên youtube
    
    //tự làm
    private static void mergeSort2(int[] arr, int left, int right){
        
        //Độ dài tối đa của mảng có thể sắp xếp được luôn.
        int max_length = 2;
        
        int n = arr.length;
        int i = 0;
        while(max_length <= n){
            int right2 = max_length + i - 1;
            int mid2 = 0;
            
            if(right2 < n - 1){
                mid2 = (right2 + i) / 2;
                merge(arr, i, mid2, right2);
                i += max_length;
            }
            
            else if(right2 == n - 1){
                mid2 = (right2 + i) / 2;
                merge(arr, i, mid2, right2);
                max_length *= 2; 
                i = 0;
            }
            
            else {
                mid2 = (n - 1 + i)/2;
                merge(arr, i, mid2, n-1);
                max_length *= 2;
                i = 0;
            }
        }
        
        if( (max_length/2) == (n - 1) ){
            merge(arr, 0, max_length/2-1, n-1);
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
        
        mergeSort2(arr, 0, n-1);
        
        for(int i = 0; i < n; i++)System.out.print(arr[i] + " ");
    }
    
}
