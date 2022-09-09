// đề bài trong folder cài đặt.
// note: ma trận ký ảo hay còn gọi là ma phương.
// note: có thể làm cách đó là liệt kê hết các trường hợp 
// nhưng cách này có thể áp dụng cho mọi ma phương lẻ
package magicsquare;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MagicSquare {

// Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int min = Integer.MAX_VALUE;
        //Ta áp dụng quy tắc (up - right, không được thì lùi) để tạo ra "ma phương lẻ".
        /*
        * Ta tiến hành up - right theo trụ 0xy.
        * Lùi theo hướng ngược lại của Oy.
        */
        //Tiến hành chọn các điểm khởi đầu ( Điểm khởi đầu có giá trị là 1 và ở giữa
        //của hàng hoặc cột ngoài cùng, nghĩa có 2 hàng 2 cột => 4 trường hợp. 
        /*
        * Ta lần lượt xoay trục Oxy 90 độ, với vị trí của giá trị khởi đầu,
        * đầu tiên là ở giữa hàng 1
        * tiếp theo đến ở giữa cột thứ n.
        * tiếp là ở giữa hàng thứ n.
        * cuối là ở giữa cột 1.
        */
        int n = 4;
        while(n > 0){
            int sum = 0;
            if(n == 4){ // Giá trị khởi đầu ở giữa hàng 1.
                sum = CompareMagicSquare(1, -1, s, 0, 1);
            }
            if(n == 3){ //Giá trị khởi đầu ở giữa cột thứ n.
                sum = CompareMagicSquare(1, 1, s, 1, 2);
            }
            else if(n == 2){ // Giá trị khởi đầu ở giữa hàng thứ n.
                sum = CompareMagicSquare(-1, 1, s, 2, 1);
            }
            else if(n == 1){ // Giá trị khởi đầu ở giữa cột 1.
               sum = CompareMagicSquare(-1, -1, s, 1, 0);
            }
            
            if(sum < min){
                min = sum;
            }
            n--;
        }
        return min;
    }
    
    /*
    * Tạo trụ Oxy.
    * Với Ox đại diện cho cột.
    * Với Oy đại diện cho hàng.
    */
    
    /*
    * x là Ox, y là Oy.
    * s là mảng ban đầu để so sánh.
    * i là vị trí hàng của giá trị ban đầu.
    * j là vị trí cột của giá trị ban đầu.
    */
    
    private static int CompareMagicSquare(int x, int y, int[][] s, int i, int j){
        int total = 0;
        int total2 = 0;
        int value = 1; // tạo giá trị khởi đầu.
        boolean[][] check = new boolean[3][3]; // tạo mảng để đánh dấu khu vực nào đã có giá trị.
        //Khởi tạo mảng với false là chưa có giá trị.
        for(int n = 0; n < 3; n++)
            for(int m = 0; m < 3; m++)
                check[n][m] = false;
        
        //điều kiện để dừng vòng lặp là value = 9;
        while(value <= 9){
            //System.out.println(i + " " + j);
            total += Math.abs(s[i][j] - value);
            /*
            * Lấy trị tuyệt đối của cột đối diện trừ đi value,
            * do có thể cùng 1 kiểu ma phương nhưng 2 cái đổi cột cho nhau.
            * ví dụ:
            *  4    9   2   |   2   9   9
            *  3    5   7   |   7   5   3
            *  8    1   6   |   6   1   8
            */
            total2 += Math.abs(s[i][3-1-j] - value);  
            value++;
            check[i][j] = true;
            int i2 = i + y; // để thay đổi i ta phải dựa vào trục Oy.
            int j2 = j + x; // để thay đổi j ta phải dựa vào trục Ox.
            
            // up - right không được thì lùi.
            if( (i2 >= 3 && j2 >= 3) || (i2 < 0 && j2 < 0) || (i2 < 0 && j2 >= 3) || (i2 >= 3 && j2 < 0)){
                // lùi theo cột.
                if(x == y){
                    j2 = j - y;
                    i2 = i;
                }
                else{ // lùi theo hàng
                    i2 = i - y;
                    j2 = j;
                }
            }
            else if( ((i2 >= 0 && i2 < 3) && (j2 >= 0 && j2 < 3) && check[i2][j2]) ){
                // lùi theo cột.
                if(x == y){
                    j2 = j - y;
                    i2 = i;
                }
                else{ // lùi theo hàng
                    i2 = i - y;
                    j2 = j;
                }
            }
            // up - right.
            else if(j2 == 3 || j2 == -1){ // đảo chiều nếu nó nằm ngoài mảng.
                j2 = (3 - j2 - 1) + x;
            }else if(i2 == 3 || i2 == -1){ // đảo chiều nếu nó lắm ngoài mảng.
                i2 = (3 - i2 - 1) + y;
            }
            
            i = i2; j = j2;
        }
        if(total2 < total) total = total2;
        //System.out.println("---------------------------" + total);
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                int sItem = scanner.nextInt();
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        System.out.println(result);

        scanner.close();
    }
}
