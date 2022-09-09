/*
 * Đề bài: 
 * Input: 
  dòng 1: số nguyên N.
  Tiếp theo nhập N cặp mảng int a và b.
Output: Sắp xếp số trong 2 mảng thành chỉ một dãy số từ lớn đến bé. 
 */
package sortarray;

import java.util.Scanner;

/**
 *
 * @author Nguyễn Văn Hoàng
 */
public class SortArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 0; i< N; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for(int x = 0; x < n; x++){
                a[x] = in.nextInt();
            }
            for(int y = 0; y < m; y++){
                b[y] = in.nextInt();
            }
            
            quickSort(a, 0, n - 1);
            quickSort(b, 0, m - 1);
            //In(a); In(b);
            merge(a, b, n, m);
        }    
    }
    
    //quicksort sắp xếp từ lớn đến bé.
    public static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int k = Partition(arr, left, right);
            quickSort(arr, left, k - 1);
            quickSort(arr, k + 1, right);
        }
    }
    
    public static int Partition(int[] arr, int left, int right){
        int mid = arr[left];
        int i = left + 1;
        int j = right;
        
        while( i <= j ){
            while(i <= j && arr[i] >= mid) i++;
            while(i <= j && arr[j] < mid) j--;
            
            if(i < j){
                int imp = arr[i];
                arr[i] = arr[j];
                arr[j] = imp;
            }    
        }
        int imp = arr[left];
        arr[left] = arr[j];
        arr[j] = imp;
        return j;
    }
    
    //trộn 2 mảng theo thứ tự giảm dần vào in ra
    public static void merge(int[] arr1, int[] arr2, int n, int m){
        int[] arr3 = new int[n+m];
        int startArr1 = 0; // ví trí đầu tiên duyệt mảng arr1;
        int startArr2 = 0; // vị trí đàu tiên duyệt mảng arr2;
        int i = 0;
        while(startArr1 < n && startArr2 < m){
            if(arr1[startArr1] < arr2[startArr2]){
                arr3[i] = arr2[startArr2];
                startArr2++;
            }else{
                arr3[i] = arr1[startArr1];
                startArr1++;
            }
            i++;
        }
        
        while(startArr1 < n){        
            arr3[i] = arr1[startArr1];
            i++; startArr1++;
        }
        
        while(startArr1 < m){        
            arr3[i] = arr2[startArr2];
            i++; startArr2++;
        }
        
        In(arr3);
        
    }
    
    public static void In(int[] arr){
        for(int j = 0; j < arr.length; j++){
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }    
}
