/*
 * Đề bài: Tìm ma trận nghịch đảo.
 */
package matrixinvese;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class MatrixInvese {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.print("Nhap n: ");
        do{
            n = scanner.nextInt();
            if(n < 2){
                System.out.print("N < 2, Vui long nhap lai n: ");
            }
        }while(n < 2);
        
        int[][] arr = new int[n][n]; 
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = scanner.nextInt();
        
        //In(arr, n);
        
//        int det = tinhDet(arr, n); 
//        System.out.println(det);

        int[][] arr2 = new int [n][n];
        for(int i = 0; i < n; i++) arr2[i][i] = 1;
        
        //duyệt xuôi
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                int so = arr[j][i];
                for(int k = 0; k < n; k++){
                    arr[j][k] = arr[j][k] * arr[i][i] - arr[i][k] * so;
                    arr[j][k] /= arr[i][i];
                    
                    arr2[j][k] = arr2[j][k] * arr[i][i] - arr2[i][k] * so;
                }
            }
        }
        
        //duyệt ngược
        for(int i = n -1; i > 0; i--){
            for(int j = i - 1; j >= 0; j--){
                int so = arr[j][i];
                for(int k = n - 1; k >= 0; k--){
                    arr[j][k] = arr[j][k] * arr[i][i] - arr[i][k] * so;
                    arr[j][k] /= arr[i][i];
                    
                    arr2[j][k] = arr2[j][k] * arr[i][i] - arr2[i][k] * so;
                }
            }
        }
        
        In(arr2, n);
        
    }
    
    
    public static int tinhDet(int[][] arr, int n){
      int det = 0;
      if(n == 2){
            det = arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
      }else{
            for(int i = 0; i < n - 2; i++){
                for(int j = i + 1; j < n; j++){
                    int so = arr[j][i];
                    for(int k = i; k < n; k++){
                        arr[j][k] = arr[i][i] * arr[j][k]  - so * arr[i][k];
                    }
                }
                In(arr, n);
            }
            
            det = arr[n-2][n-2] * arr[n-1][n-1] - arr[n-2][n-1] * arr[n-1][n-2];           
            for(int i = 0; i < n - 2; i++){
                if(i == n - 3){
                    det /= arr[i][i];
                }else{
                    int so_chia = arr[i][i] * arr[i][i];
                    det /= so_chia;
                }
                
            }        
        }
      return det;
    }
    
    private static void In(int[][] arr, int n){
        System.out.println("---------------");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) System.out.print(arr[i][j] + " ");
            System.out.println();    
        }        
    }
}
