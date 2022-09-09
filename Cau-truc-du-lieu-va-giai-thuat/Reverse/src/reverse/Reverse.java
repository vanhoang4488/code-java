/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverse;

import java.util.Scanner;

/**
 *
 * @author Nguyễn Văn Hoàng
 */
public class Reverse {

    /**
     * @param args the command line arguments
     */
    private static boolean reverse(String s){
        System.out.println(new StringBuilder(s).reverse().toString());
        return (s.equals(new StringBuilder(s).reverse().toString()))?true:false;
    }
    
    private static boolean reverse(int s){
        System.out.println(new StringBuilder(s).reverse().toString());
        return (String.valueOf(s).equals(new StringBuilder(s).reverse().toString()))?false:true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String s = sc.next();
        int n = sc.nextInt();
        //System.out.println(reverse(s));
        System.out.println(reverse(n));
    }
    
}
