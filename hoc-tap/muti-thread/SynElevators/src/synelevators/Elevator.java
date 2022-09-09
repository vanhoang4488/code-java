/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synelevators;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Elevator{
    private String id;
    private int floor_now;
    //hướng di chuyển của thang máy.
    //0 là đứng yên.
    //1 là đi lên.
    //2 là đi xuống.
    private int vector;
    //danh sách các User cần đón.
    private List<User> arr1;
    //danh sách các User cần trả.
    private List<User> arr2;
    
    public Elevator(String id){
        this.id = id;
        this.vector = 0;
        this.floor_now = 1;
        this.arr1 = new ArrayList<>();
        this.arr2 = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<User> getArr1() {
        return arr1;
    }

    public void setArr1(List<User> arr1) {
        this.arr1 = arr1;
    }

    public List<User> getArr2() {
        return arr2;
    }

    public void setArr2(List<User> arr2) {
        this.arr2 = arr2;
    }
    
    
}
