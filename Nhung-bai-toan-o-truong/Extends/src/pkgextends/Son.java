/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgextends;

/**
 *
 * @author Nguyen Van Hoang
 */
public class Son extends Father{
    int b;
    public Son(){
      super("", 0);
    }
    public Son(String a, int b) {
        super(a, b);
        this.name =a ;
        this.a = b;
    }
    
    public Son(String a, int b, int c){
       super(a, b);
    }
    
}
