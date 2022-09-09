/*
 * ĐỀ bài: giải bài toán tháp hà nội.
https://www.youtube.com/watch?v=29_S0mx1r_k
 */
package towerofhanoi;

import java.util.Scanner;

/**
 *
 * @author ABC
 */
public class TowerOfHaNoi {

    private int nhap(){
        Scanner sc = new Scanner(System.in);
        int a = -1;
        while(a < 0){
            try{
                System.out.print("Nhap so tu nhien: ");
                a = sc.nextInt();
                if(a < 0) System.out.println("ban da nhap sai! Vui long nhap lai....");
            }catch(Exception e){
                System.out.println("ban da nhap sai! Vui long nhap lai....");
                sc.nextLine();
            }
        }
        return a;
    }
    
    private void chuyenTower(int n, String nguon, String trunggian, String dich){
         if(n == 1){
             System.out.println(String.format("Chuyen 1 dia tu %s sang %s", nguon, dich));
         }else{    
             //Chuyển n - 1 đĩa từ nguon sang trunggian lấy dich là cọc trung gian.
             chuyenTower(n - 1, nguon, dich, trunggian);
             
             //Chuyển đĩa con lại ở nguon sang dich
             System.out.println(String.format("Chuyen 1 dia tu %s sang %s", nguon, dich));
             
             //chuyển n -1 đĩa ở cọc trunggian sang dich bằng cách lấy nguon làm cọc trung gian.
             chuyenTower(n - 1, trunggian, nguon, dich);
                          
         }
         
    }
    
    public static void main(String[] args) {
        TowerOfHaNoi tower = new TowerOfHaNoi();
        int n = tower.nhap();
        
        tower.chuyenTower(n, "A", "B", "C");
    }
    
}
