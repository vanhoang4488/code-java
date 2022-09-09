/*
* Đề bài lưu trong folder cài đặt.
*/
package circular_array;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Circular_Array {

    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int[] arr = new int[queries.length]; 
        // tìm vị trí của giá trí tại 0 ban đầu sau k bước.
        int n = a.length;
        int b = 0;
        if(k%n == 0) b = 1;
        else {
            b = k % b + 1;
            if(b == 0) b = 3;
        }
        //end; 
        for(int i = 0; i < queries.length; i++){
            int pos = queries[i] + 1;
            if(pos >= b) pos = pos - b;
            else pos = (n - b) + pos;
            if(pos == 289) System.out.println("----------------" + i);
            arr[i] = a[pos];
        }
        return arr;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scan.nextInt();

        int k = scan.nextInt();

        int q = scan.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            queries[i] = scan.nextInt();
        }

        int[] result = circularArrayRotation(a, k, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        scan.close();
    }
}
