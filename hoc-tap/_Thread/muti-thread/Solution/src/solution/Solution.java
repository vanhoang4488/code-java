package solution;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Tại sao, kết quả cứ loạn hết lên: 0, -100, 1000, 900
 * Nếu tường lượng theo nhiều cpu thì kết quả khá hợp lý -> bởi phụ thuộc vào tốc độ xử lý của cpu
 * Nhưng nếu xét theo cơ chế chia sẻ thời gian -> không ra.
 *
 * => nhưng giờ làm đa luồng thì tưởng tượng theo nhiều cpu đi, vì trong tài liệu cũng chỉ nói
 * là "thực ra trong máy 1 cpu thì cơ chế thực của đa luồng là chia sẻ thời gian" -> cứ tưởng
 * tượng theo đa cpu đi.
 */
public class Solution {


    public static void main(String[] args) {
        Bank bank = new Bank(10, 1000);

        Thread t1 = new Thread (new TransferThread(bank, 1, 2));
        Thread t2 = new Thread(){
            @Override
            public void run(){
                bank.display(1);
            }
        };

        Thread t3 = new Thread(){
            @Override
            public void run(){
                bank.total(1, 1000);
            }
        };
        t1.setPriority(2);
        t2.setPriority(6);
        t3.setPriority(10);
        t1.start();
        t2.start();
        t3.start();
    }
}