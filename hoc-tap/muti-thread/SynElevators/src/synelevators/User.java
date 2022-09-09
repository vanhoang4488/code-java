/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synelevators;

import java.util.concurrent.ThreadLocalRandom;

public class User extends Thread{
    private int floor_now;
    //muốn đi xuống hay đi lên;
    //1 là đi lên.
    //2 là đi xuống.
    private int vector;
    //tầng muốn đến.
    private int floor_next;
    
    private ElevatorsManager manager;
    
    public User(ElevatorsManager manager, String id){
        super(id);
        this.manager = manager;
        this.floor_now = ThreadLocalRandom.current().nextInt(1, SynElevators.MAX_FLOORS+1);
        //nếu floor_now = MAX_FLOORS => vector chỉ có thể = 2.
        switch (floor_now) {
            case SynElevators.MAX_FLOORS:
                vector = 2;
                break;
            case 1:
                vector = 1;
                break;
            default:
                vector = ThreadLocalRandom.current().nextInt(1, 3);
                break;
        }
    }
    
    @Override
    public void run(){
        manager.manager(this);
    }

    public int getFloor_now() {
        return floor_now;
    }

    public void setFloor_now(int floor_now) {
        this.floor_now = floor_now;
    }

    public int getVector() {
        return vector;
    }

    public void setVector(int vector) {
        this.vector = vector;
    }

    public int getFloor_next() {
        return floor_next;
    }

    public void setFloor_next(int floor_next) {
        this.floor_next = floor_next;
    }
    
    
}
