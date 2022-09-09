/*
 * Đề bài và test case trong file nguồn.
 */
package twopluses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
class Result {
    
    public static int twoPluses (List<String> grid){
        if(grid.size() == 2) return 1;
        
        int n = grid.size();
        int m = grid.get(0).length();
        char[][] grid2 = new char[n][m];
       
        return 1;
    }
    
}

public class TwoPluses {

    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException{
        
        int n = check(input.nextInt());
        int m = check(input.nextInt());
        
        List<String> grid = new ArrayList<String>();
        
        for(int i = 0; i < n; i++){
            
            String str = input.next();
            
            if(str.length() < m) {
                for(int k = 0; k <= m - str.length(); k++) str += "B";
            }
            
            if(str.length() > m) str = str.substring(0, m);
            
            grid.add(str);
            
        }

        //int result = Result.twoPluses(arr);
        
        //System.out.println(result);
    }
    
    public static int check(int so) {
    
        while(so < 2 || so > 15) {
            System.out.print("So nhap vao phai: \' 2 <= so <= 15 \': ");
            so = input.nextInt();
        }
        
        return so;
    }
    
    public static void toString(List<String> grid, int n){
        
        for(int i = 0; i < n; i++){
            System.out.println(grid.get(i));
        }
    }
}
