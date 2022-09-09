package lab06;

import java.util.ArrayList;
import java.util.Scanner;

public class Diagram {
    Scanner sc = new Scanner(System.in);
    private int soluong;
    ArrayList<Layer> list = new ArrayList<Layer>();
    public Diagram(){
        System.out.print("Nhap so luong Layer: ");
        soluong = sc.nextInt();
        for(int i=0; i < soluong; i++){
             list.add(new Layer());
        }
    }
    
    public void deleteCir(){
        for(int i=0; i<soluong; i++)
            list.get(i).deleteCir();
    }
    
    public String toString(){
        String value = "value[";
        for(int i=0; i< list.size(); i++){
            value += " " + list.get(i).toString();
        }
        value +=" ]";
        return value;
    }
}
