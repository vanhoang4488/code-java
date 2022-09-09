/*
 * tìm các số nguyên tố nhỏ hơn hoặc bằng n.
 */
package timsont;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ABC
 */
public class TimSoNT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for(int i = 2; i <= n; i++){
            arr.add(i);
        }   
        
        //tìm số nguyên tố bằng các loại bỏ dần dần
        for(int i = 0; i <= arr.size(); i++){
            for(int j = i + 1; j < arr.size(); j++){
               if( (arr.get(j)) % (arr.get(i)) == 0 ) arr.remove(j);
            }
        }
        
        for(int i = 0; i < arr.size(); i++)
            System.out.print(arr.get(i) + " ");
    }
}
