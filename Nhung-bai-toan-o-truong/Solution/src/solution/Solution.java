/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author Nguyễn Văn Hoàng
 */
public class Solution {
    
    
    public static boolean canWin(int leap, int[] game) {
        int i = 0;
        int n = game.length;
        boolean check = false;
        Stack st = new Stack();
        st.push(i);
        while(!st.empty() && (i+leap<n) && (i < n-1)){
              i = (Integer) st.peek();
              int so1 = i + 1;
              int so2 = i - 1;
              int so3 = i + leap;
              boolean check2 = false;
              if(so1<n && game[so1]==0){
                  check2 = true;
                  st.push(so1);
              }
              
              if(so2 > 0 && game[so2]==0){
                  check2 = true;
                  st.push(so2);
              }
              
              if(so3 < n && game[so3]==0){
                  check2 = true;
                  st.push(so3);
              }
              
              if(!check2) st.pop();
              game[i] = 1;
        }
        if(!st.empty()) check = true;
        return check;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
            
        }
        
        scan.close();
    }
}

