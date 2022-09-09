package lab06;

import java.util.ArrayList;
import java.util.Scanner;

public class Layer {
    private int soluong;
    Scanner sc = new Scanner(System.in);
    ArrayList<Shape> list = new ArrayList<Shape>();
    
    public Layer(){
        System.out.print("Nhap so luong Shape: ");
        soluong = sc.nextInt();
        for( int i=0; i< soluong; i++){
            String b = sc.next();
            luachon(b);
        }
        deleteTri();
    }
    
    public void luachon(String a){
        switch(a){
            case "Circle":
                list.add(new Circle());
                break;
            case "Triangle":
                list.add(new Triangle());
                break;
            case "Rectangle":
                list.add(new Rectangle());
                break;
            case "Square":
                list.add(new Square());
                break;
        }
    }
    
    public void deleteTri(){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).toString().equals("Triangle")){
                list.remove(i);
                i--;
            }
        }
    }
    
    public void deleteCir(){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).toString().equals("Circle"))
            {
                list.remove(i);
                i--;
            }    
        }
    } 
    
    public String toString(){
        String value = "value[";
        for(int i=0; i< list.size(); i++){
            value += " " +list.get(i).toString();
        }
        value +=" ]";
        return value;
    }
}
