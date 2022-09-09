/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

/**
 *
 * @author hoang
 */
public class TestThread {
    
    private int i;
    
    private String name = "hoang";
    
    public void testSynchron(){
    
      System.out.println("--------------" + i++);
      
      synchronized(name){
          System.out.println(name);
      }
      
      System.out.println("===================");
        
    }
    
}
