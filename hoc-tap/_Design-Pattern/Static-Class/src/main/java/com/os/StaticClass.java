package com.os;

public class StaticClass {

    public static void main(String[] args){
        AnimalFactory.Setter().withAge(12);

        AnimalFactory.Setter setter = AnimalFactory.Setter();

        System.out.println(setter.getAge());
    }
}
