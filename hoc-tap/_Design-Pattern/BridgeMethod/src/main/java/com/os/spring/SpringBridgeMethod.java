package com.os.spring;

import org.springframework.core.BridgeMethodResolver;

import java.lang.reflect.Method;

public class SpringBridgeMethod {

    public static void main(String[] args) throws NoSuchMethodException {
        Animal animal = new Cat();
        Method method = animal.getClass().getMethod("sound", new Class[]{Animal.class});
        System.out.println("===> method: " + method.toString());
        System.out.println("===> method is bridge method: " + method.isBridge());
        Method specifiedMethod = BridgeMethodResolver.findBridgedMethod(method);
        System.out.println("===> bridgeMethod: " + specifiedMethod.toString());
    }
}

interface Animal<T extends Animal<T>>{
    T display();
    void sound(T t);
}

class Cat implements Animal<Cat>{

    public Cat display(){
        return this;
    }

    public void sound(Cat sound){
        System.out.println("===> sound: " + sound);
    }
}
