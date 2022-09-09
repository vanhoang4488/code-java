package com.os;

interface Shape <T extends Shape<T>>{
    T getType();

    void setType(T shape);
}

class Circle implements Shape<Circle> {

    public Circle getType(){
        System.out.println("getCircle --------");
        return this;
    }

    public void setType(Circle circle){
        System.out.println("setCircle -----------");
    }
}

public class BridgeMethod {

    /**
     * Xem lý giải ở BridgeMethod2
     * @param args
     */
    public static void main(String[] args){
        Shape shape = new Circle();
        Circle circle = new Circle();
        Circle c = (Circle) shape.getType();
        shape.setType(shape);
    }

}
