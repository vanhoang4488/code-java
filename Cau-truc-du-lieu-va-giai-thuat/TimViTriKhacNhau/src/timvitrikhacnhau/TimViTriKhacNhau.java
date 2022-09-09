/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timvitrikhacnhau;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nguyễn Văn Hoàng
 */
public class TimViTriKhacNhau {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> l1= new ArrayList<String>();
        ArrayList<String> l2= new ArrayList<String>();
        while(in.hasNext()){
            l1.add(in.next());
        }
        
        while(in.hasNext()){
            l2.add(in.next());
        }
        
        for(int i = 0; i< l1.size(); i++){
            if(l1.get(i) != l2.get(i)) System.out.println(i);
        }    
    }
    
}
