/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synelevators;

import java.util.List;

/**
 *
 * @author hoang
 */
public class SynElevators {

    public static final int MAX_FLOORS = 20;
    public static final int MAX_ELEVATORS = 1;
    
    public static void main(String[] args) {
        
        ElevatorsManager manager = new ElevatorsManager();
        
        //tạo ra các Users.
//        for(int i = 1; i < 10; i++){   
//            User user = new User("Name:" + i);
//            user.setPriority(Thread.NORM_PRIORITY + 1 + i%2);
//            user.start();
//        }

          User user = new User(manager, "1");
          user.start();
          User user2 = new User(manager, "2");
          user2.start();
          
    }
    
}
