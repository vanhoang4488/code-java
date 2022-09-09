/*
 * Đề bài: Cho mảng n số nguyên. Tìm tích hai số nguyên lớn nhất.
 */
package maxtich;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class MaxTich {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n; i++){
            arr[i] = sc.nextInt();
        }    
         
        quickSort(arr, 0, n - 1);
        
        System.out.println(((arr[0]*arr[1]) > (arr[n-2]*arr[n-1]))?(arr[0]*arr[1]):(arr[n-2]*arr[n-1]));
    }
    
    private static int Partition(int[] arr, int left, int right){
       int i = left + 1;
       int mid = arr[left];
       int j = right;
    
       while(i <= j){
          while(i <= j && arr[i] <= mid) i++;
          while(i <= j && arr[j] > mid) j--;
          
          if(i < j){
              int imp = arr[i];
              arr[i] = arr[j];
              arr[j] = imp;
              i++; j--;
          }
       }
       
       int imp = arr[j];
       arr[j] = mid;
       arr[left] = imp;
       
       return j;
    }    
    
    
    private static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int mid = Partition(arr, left, right);
            
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }
}
