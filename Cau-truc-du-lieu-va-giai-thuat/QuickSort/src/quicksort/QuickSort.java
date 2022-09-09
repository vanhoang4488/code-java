/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;
import java.util.*;
/**
 *
 * @author Nguyễn Văn Hoàng
 */
public class QuickSort {
    
    //học trên youtube
    private static int partition(int[] arr, int left, int right){
        int i = left + 1;
        int j = right;
        int pivot = arr[left];
        while(i <= j){
            while(i <= j && arr[i] <= pivot) i++;
            while(i <= j && arr[j] > pivot) j--;
            
            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++; j--;
            }
        }
        
        arr[left] = arr[j];
        arr[j] = pivot;
        
        return j;
    }
    
    private static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int search_point = partition(arr, left, right);
            quickSort(arr, left, search_point - 1);
            quickSort(arr, search_point + 1, right);
        }
    }
    
    //học trên youtube
    
    //cảm thấy tự làm sang mảng for khó hiểu và giống săp xếp trộn nên thôi.
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
        
        quickSort(arr, 0, n - 1);
        
        for(int i = 0; i < n; i++) System.out.print(arr[i] + " ");
    }
    
}
