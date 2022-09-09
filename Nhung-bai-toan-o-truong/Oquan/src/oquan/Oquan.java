
package oquan;

import java.util.Scanner;


public class Oquan {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        TestCase test = new TestCase();
        
        test.gieo();
      
        System.out.println("Max: " + test.getMax());
    }
    
}
