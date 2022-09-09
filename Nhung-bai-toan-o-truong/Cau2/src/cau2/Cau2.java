package cau2;
import java.util.Scanner;

public class Cau2 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       Shape[] list = new Shape[3];
       double radius = sc.nextDouble();
       list[0] = new Cricle(radius);
       double width = sc.nextDouble(), length = sc.nextDouble();
       list[1] = new Rectangle(width, length);
       double side = sc.nextDouble();
       list[2] = new Square(side);
       
       System.out.println(list[2].toString());
       for(int i=0; i<3; i++){
           System.out.println(list[i].toString());
       }
    }
}
