/*
 * ĐỀ bài: kiểm tra một số có là số nguyên tố hay không;
 */
package isprime;

import java.util.Scanner;

/**
 *
 * @author Nguyễn Văn Hoàng
 */
public class IsPrime {

    /**
     * @param args the command line arguments
     */
    private static boolean isPrime(int n){
        if(n < 2) return false;
        else if(n == 2) return true;
        else if(n % 2 == 0) return false;
        
        int sqrt = (int) Math.sqrt(n);
        for(int i = 3; i <= sqrt; i+=2){
            if(n % i == 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        System.out.println(isPrime(n));
            
    }
    
}
