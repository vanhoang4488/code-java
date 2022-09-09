/*
 * Viết chương trình tìm ước số chung lớn nhất, bội số chung nhỏ nhất của hai số tự nhiên a và b
 */
package ucln.bcnn;
import java.util.Scanner;

public class UCLNBCNN {

    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       UCLNBCNN ub = new UCLNBCNN();
       int s1 = sc.nextInt();
       int s2 = sc.nextInt();
       System.out.println("UCLN: " + ub.UCLN(s1, s2));
       System.out.println("BCNN: " + ub.BCNN(s1, s2));
    }
    
    private int UCLN(int a, int b){
        while(a != b){
           if(a > b) a = a - b;
           else b = b - a;
        }
        //if(a == 1 || b == 1) a = 1;
        return a;
    }
    
    private int BCNN(int a, int b){
        int bcnn = 0;
        for(int i = 0; i<= a*b; i++){
                if( i % a == 0 && i % b == 0) bcnn = i;
        }
        
        return bcnn;
    }
}
