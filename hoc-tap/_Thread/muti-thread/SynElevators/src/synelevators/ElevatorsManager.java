/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synelevators;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ElevatorsManager {

    //danh sách thang máy.
    private List<Elevator> elList;
    
    public ElevatorsManager(){
        elList = new ArrayList<>();
        for(int i = 1; i <= SynElevators.MAX_ELEVATORS; i++)
            elList.add(new Elevator("ID: " + i));
    }
    
    public synchronized void manager(User user){
       
        int min = Integer.MAX_VALUE;
        int floor_now = user.getFloor_now();
        int vector = user.getVector();
        Elevator elevator = null;
        
        do{
           int far = Integer.MAX_VALUE;
           for(Elevator e : elList){
              /*
               * Quy để lựa chọn thang máy đón khách là:
               * 1. Thang máy hiện chưa phục hay đứng yên sẽ được xem xét đến đón khách.
               * 2. Thang máy đang trả khách và cùng chiều di chuyển với yêu cầu của user,
               * và đáp ứng yêu cầu về tầng.
               * - Lưu ý: không tiến hành đón khách khi thang máy đang đi đón khách vì điều này
               * có thể gây nên nhập nhằng về logic.
               * 3. Xem thang máy nào gần user hơn thì xét duyệt thang máy đó. Nếu không có thang máy nào
               * thì user đó sẽ phải chờ đến khi có thang máy đủ yêu cầu.
               */
              if(e.getVector() == 0){
                  far = Math.abs(e.getFloor_now() - floor_now);
              }
              else if(!e.getArr2().isEmpty() && e.getVector() == vector){
                  if(vector == 2 && floor_now > e.getArr2().get(0).getFloor_next())
                      far = e.getFloor_now() - floor_now;
                  else if(vector == 1 && floor_now < e.getArr2().get(0).getFloor_next())
                      far = floor_now - e.getFloor_now();
              }
              
              if(far < min){
                  min = far;
                  elevator = e;
              }
           } 
           System.out.println(user.getName() + " " + user.getFloor_now() + " " + user.getVector());
           if(elevator == null) try {
               wait();
           } catch (InterruptedException ex) {
               ex.printStackTrace();
           }
           
        }while(elevator == null);
        System.out.println("---------");
        /*
         * Với thang máy hiện đang đứng yên thì
         * cần làm thêm bước xác dịnh vector cho thang máy.
        */
        if(elevator.getVector() == 0){
            //trường hợp thang máy cùng tầng với user
            //khi này không cần đón khách nữa
            //và chiều đi của đi của thang máy trùng với chiều đi của User.
            if(elevator.getFloor_now() == floor_now){
                elevator.setVector(vector);
                elevator.getArr2().add(user);
            }else{
                if(elevator.getFloor_now() < floor_now) elevator.setVector(1);
                else elevator.setVector(2);
                elevator.getArr1().add(user);
            }
            
//            Move move = new Move(elevator.getId(), elevator);
//            Thread thread = new Thread(move);
//            thread.setPriority(Thread.NORM_PRIORITY + 2);
//            thread.start();
        }
        else{
            elevator.getArr1().add(user);
        }
        notifyAll();
    }
    
    public List<Elevator> getElList(){
        return elList;
    }
}
