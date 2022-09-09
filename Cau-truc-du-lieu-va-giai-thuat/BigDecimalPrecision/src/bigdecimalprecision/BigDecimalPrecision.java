/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigdecimalprecision;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Nguyễn Văn Hoàng
 */
public class BigDecimalPrecision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double m = sc.nextDouble();
        //String m = sc.nextLine();
        BigDecimal d = new BigDecimal(Double.toString(m));
        System.out.println(d);
    }
    
}
