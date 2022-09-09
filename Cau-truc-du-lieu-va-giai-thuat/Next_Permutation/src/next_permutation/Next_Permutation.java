/*
    Đề bài trong folder.
    Đây là bài toán tìm hậu tố tiếp theo mà mấu chốt là hiểu hậu tố là gì.
*/
package next_permutation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Next_Permutation {

    // Complete the biggerIsGreater function below.
    public static char[] swap(char data[], int left, int right) 
    { 
  
        // Swap the data 
        char temp = data[left]; 
        data[left] = data[right]; 
        data[right] = temp; 
  
        // Return the updated array 
        return data; 
    } 
  
    // Function to reverse the sub-array 
    // starting from left to the right 
    // both inclusive 
    public static char[] reverse(char data[], int left, int right) 
    { 
  
        // Reverse the sub-array 
        while (left < right) { 
            char temp = data[left]; 
            data[left++] = data[right]; 
            data[right--] = temp; 
        } 
  
        // Return the updated array 
        return data; 
    } 
  
    // Function to find the next permutation 
    // of the given integer array 
    public static String biggerIsGreater(String w) 
    { 
        char[] data = w.toLowerCase().toCharArray();
  
        // If the given dataset is empty 
        // or contains only one element 
        // next_permutation is not possible 
        if (data.length <= 1) 
            return "no answer"; 
  
        int last = data.length - 2; 
  
        // find the longest non-increasing suffix 
        // and find the pivot 
        while (last >= 0) { 
            if (data[last] < data[last + 1]) { 
                break; 
            } 
            last--; 
        } 
  
        // If there is no increasing pair 
        // there is no higher order permutation 
        if (last < 0) 
            return "no answer"; 
  
        int nextGreater = data.length - 1; 
  
        // Find the rightmost successor to the pivot 
        for (int i = data.length - 1; i > last; i--) { 
            if (data[i] > data[last]) { 
                nextGreater = i; 
                break; 
            } 
        } 
  
        // Swap the successor and the pivot 
        data = swap(data, nextGreater, last); 
  
        // Reverse the suffix 
        data = reverse(data, last + 1, data.length - 1); 
  
        // Return true as the next_permutation is done 
        return new String(data); 
    } 
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       

        int T = scanner.nextInt();
        scanner.nextLine();

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            System.out.println(result);
        }

        scanner.close();
    }
}
