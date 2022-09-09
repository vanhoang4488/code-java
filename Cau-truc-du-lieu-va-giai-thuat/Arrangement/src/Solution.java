import java.util.Arrays;
import java.util.Scanner;

/*
 * Đề bài: Tìm tổ hợp chập k của n
 */

public class Solution {

    //Mục đích in ra cấu trúc cây.
    public static void loop(int[] a, int i, int n, int k, int len, int[] arr){
        for(;i <= n - k + len - 1; i++){
            arr[len-1] = a[i];
            if(len < k)
                loop(a, i + 1, n, k, len + 1, arr);
            else
                display(arr);

        }
    }

    private static void display(int[] arr){
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = i + 1;
        loop(a, 0, n, k, 1, new int[k]);
    }
}
