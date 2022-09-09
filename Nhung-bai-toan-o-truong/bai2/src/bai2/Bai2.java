package bai2;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
          Scanner input = new Scanner(System.in);
          int a , b, c , d;
          a = input.nextInt();
          b = input.nextInt();
          c = input.nextInt();
          d = input.nextInt();
          
          Ps s1 = new Ps(a,b);
          Ps s2 = new Ps(c,d); 
          
          String pheptinh;
          pheptinh = input.next();
          switch (pheptinh){
              case "+":
                  s1.cong(s2);
                  break;
              case "-":
                  s1.tru(s2);
                  break; 
              case "*":
                  s1.nhan(s2);
                  break; 
              case "/":
                  s1.chia(s2);
                  break; 
              case "sosanh":
                  System.out.println("gia tri la:" + s1.equals(s2));
                  break;
          }
    }
    
}
