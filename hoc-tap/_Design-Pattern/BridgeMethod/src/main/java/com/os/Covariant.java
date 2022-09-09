package com.os;

import org.springframework.core.BridgeMethodResolver;

import java.lang.reflect.Method;

/**
 * Đây là phủ định của class GFG => khó hiểu vl.
 */

/**
 * Even without generics, bridge methods are necessary for covariant return types.
 * => chỉ cần thiết ở các phiên bản Java < 1.5
 */
class Robot{
    public void get(){

    }
}
class MewRobot extends Robot{

//    @Override
//    public Cat get(){
//        return this;
//    }

//    public Animal sound(Animal a){
//        return sound((Cat) a);
//    }
//    public Cat sound(Cat a){
//        return this;
//    }
}


public class Covariant {

    public static void main(String[] args) throws NoSuchMethodException {

        Method method = MewRobot.class.getMethod("get");
        System.out.println("method is bridge: " + method.isBridge());
        Method bridgeMethod = BridgeMethodResolver.findBridgedMethod(method);
        System.out.println("bridge method: " + bridgeMethod.toString());
    }
}
