/*
    Đề bài: trong folder cài đặt.
    Để giải bài toán ta sử dụng quy tắc:
        +> (A + B) % k == 0 khi và chỉ khi A % k + B % k == k.
        +> Trường hợp đặc biệt là A % k == 0 và B % k == 0 => (A+B) % k == 0.
*/
package non.divisible_Subset;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NonDivisible_Subset {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < s.size(); i++){
           int remainder = s.get(i) % k;
           if(!map.containsKey(remainder)){
               map.put(remainder, 1);
           }else{
               int frequency = map.get(remainder);
               map.put(remainder, ++frequency);
           }
        }
        int max = 0;
        Iterator<Integer> itr = map.keySet().iterator();
        while(itr.hasNext()){
            int key = itr.next();
            int value = map.get(key);
            if(key == 0) max++;
            else if(k % 2 == 0 && key == k / 2) max++;
            else if(map.containsKey(k - key) && key <= k/2){
                int value2 = map.get(k - key);
                if(value >= value2) max += value;
                else max += value2;
            }else if(!map.containsKey(k - key)){
                max += value;
            }
        }
        return max;
    }

    
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scan.nextInt();
        int k = scan.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(scan.nextInt());
        scan.close();
        System.out.println(nonDivisibleSubset(k, list));
    }
}
