package lab05;
import java.util.Scanner;

public class Lab05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount;
        String date;
        String nguongoc;
        double giaban;
        
        HoaQua[] list = new HoaQua[4];
        list[0] = new QuaCam();
        list[1] = new QuaTao();
        list[2] = new QuaCaoPhong();
        list[3] = new lab.QuaSanh();
        for(int i=0; i<4; i++){
           System.out.print("Nhap thong tin cua " + list[i].getName()+" :");
           amount = sc.nextInt();
           date = sc.next();
           nguongoc = sc.next();
           giaban = sc.nextDouble();
           list[i].object(amount, date, nguongoc, giaban);
        }
        for (int i=0; i<4; i++){
           list[i].infor();
        }
    }  
}
