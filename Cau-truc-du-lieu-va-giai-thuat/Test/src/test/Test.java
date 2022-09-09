/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] grid = new String[2];
        char[][] arr = new char[][]{{'a','b'}, {'a','b'}};
        grid[0] = String.valueOf(arr[1]);
        System.out.println(grid[0]);
    }
    
}
