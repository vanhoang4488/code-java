/*
 * Đề bài:
   Cho mảng N sô nguyên và M. Tìm M số liền nhau số các chữ số khác nhau.
VD: 6 3
5 3 5 2 3 2 => 3
 */
package dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Nguyễn Văn Hoàng
 */
public class Dequeue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            
            deque.add(input);
            set.add(input);
            
            if (deque.size() == m) {
                if (set.size() > max) max = set.size();
                int first = deque.remove();
                if (!deque.contains(first)) set.remove(first);
            }
        }
        
        System.out.println(max);
    }
    
   
}
