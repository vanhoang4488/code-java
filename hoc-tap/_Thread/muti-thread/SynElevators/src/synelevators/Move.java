/*
 * Lớp là luồng chịu trách nhiệm trong việc
 * di chuyển các thang máy.
*/
package synelevators;

import static java.lang.Thread.sleep;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Move implements Runnable{
    
    private Elevator e;
    private String name;
    
    public Move(String name, Elevator e){
        super();
        this.name = name;
        this.e = e;
    }
    
    @Override
    public void run() {
            
        while(e.getVector() != 0){
            int vector = e.getVector();    
            int floor_now = e.getFloor_now();
            
            if(vector == 1)
                if(floor_now < SynElevators.MAX_FLOORS) e.setFloor_now(++floor_now);
            
            if(vector == 2)
                if(floor_now > 1) e.setFloor_now(--floor_now);
            
            List<User> arr2 = e.getArr2();
            
            // đến đón khách.
            List<User> arr1 = e.getArr1();
            for(int i = 0; i < arr1.size(); i++){
                User user = arr1.get(i);
                if(floor_now == user.getFloor_now()) {
                    arr1.remove(i);
                    System.out.printf("thang %s don user %s tai tang %d\n", 
                            e.getId(), user.getName(), floor_now);
                    int floor_next = ThreadLocalRandom.current().nextInt(1, SynElevators.MAX_FLOORS+1);
                    
                    if(arr2.isEmpty()){
                        if(floor_next > floor_now) e.setVector(1);
                        else e.setVector(2);
                    }
                    
                    user.setFloor_next(floor_next);
                    arr2.add(user);
                }
            }
            //kiểm tra xem còn user nào cần trả theo chiều hiện tại hay không.
            //nếu không còn user nào cần trả theo chiều hiện tại.
            //và không còn  khách hàng naò cần đón theo chiều hiện tại
            //và còn user cần trả ngược chiều chuyển động thang máy
            //=> đổi chiều di chuyển của thang máy.
            boolean check = false;
            // trả khách
            for(int i = 0; i < arr2.size(); i++){
                User user = arr2.get(i);
                if(floor_now == user.getFloor_next()) {
                    arr2.remove(i);
                    System.out.printf("Thang %s tra user %s tai tang %d\n", 
                            e.getId(), user.getName(), floor_now);
                }
                if(vector == 1){
                    if(user.getFloor_next() > floor_now) check = true;
                }
                else if(vector == 2){
                    if(user.getFloor_next() < floor_now) check = true;
                }
            }
                
            if(arr1.isEmpty() && arr2.isEmpty()) e.setVector(0);
            else if(!check && !arr2.isEmpty() && arr1.isEmpty()) e.setVector(3 - e.getVector());
            //System.out.println(e.getVector());
            
            try {
                
                sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
