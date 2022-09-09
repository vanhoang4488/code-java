/*
 * Đề bài: 
 *     1 thread tiến hành duyệt mảng.
 *     1 thread tiến hành xóa cùng lúc với thread xóa. 
 * => Vẫn hoạt động bình thường mà không xảy ra lỗi hơn.
 */
package arraylistaddandremove;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class ArrayListAddAndRemove {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) 
            list.add(scan.nextInt());
        
        int pos = scan.nextInt();
        
        Thread t1 = new Thread(new Runnable(){
            
            @Override
            public void run(){
                for(int i = 0; i < list.size(); i++)
                    System.out.print(list.get(i) + " ");
                System.out.println();
            }
        });
        
        
        Thread t2 = new Thread(new Runnable(){
        
            @Override
            public void run(){
                
                list.remove(pos);
            }
        });
        
        t1.start();
        t2.start();
    }
    
}
