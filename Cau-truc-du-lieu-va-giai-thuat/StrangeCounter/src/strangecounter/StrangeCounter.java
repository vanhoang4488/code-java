/*
    Đề bài trong phần folder lưu trữ.
    *Lý giải bài làm:
    - gọi i là Bảng chứa giá trị thời gian thứ i, trong đó giá trị thời gian lớn nhất nhỏ hơn t, r giá trị.
    +> r >=0;
    => 3 + 3*2 + 3*2^1 + 3*2^2 + ..... + 3 * 2^n + r = t;
    <=> 3*(2^i+1 - 1) + r = t;
    => 3*(2^i+1 - 1) <= t;
    => i + 1 <= log2(t/3 + 1);
    => i + 1 = floor(log2(t/3 + 1)).
*/
package strangecounter;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StrangeCounter {

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
        int i = 63 - Long.numberOfLeadingZeros( t/3 + 1);
        System.out.println(i);
        long a1 = 3*( (long) Math.pow(2, i) - 1);
        if(a1 == t) return 1; // vì r >= 0 => t có thể nằm từ a(i) -> a(i+1).
        
        long a = 3*( (long) Math.pow(2,i+1) - 1);
        long c = a - t + 1;
        return c;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(("OUTPUT_PATH.txt")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
