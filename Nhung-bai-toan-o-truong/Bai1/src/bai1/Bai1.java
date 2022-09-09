package bai1;
import java.util.Scanner;

public class Bai1 {
    public static int ucln(int a , int b){
        while(a!=b)
        {
         if(a>b)
             a = a -b;
         else
             b = b -a;
        }
        return a;
    }
    public static int fibonaxi(int[] a, int n){
        a[0] = 0;
        a[1] =1;
        for ( int i = 2 ; i<=n ;i++){
            a[i] = a[i-1] +a[i-2];
        } 
        return a[n];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a , b , n ;
        a = input.nextInt();
        b = input.nextInt();
        System.out.println("uoc chung lon nhat la: "+ucln(a,b));
        n = input.nextInt();
        int[] c = new int[n+1];
        System.out.println("so fibonaxi thu n la: " + fibonaxi(c,n));
    }
    
}
