package com.os;


import lombok.Getter;

public class AnimalFactory {

    private static String default_name = "animal";

    private static int default_age = 1;


    public static Animal getAnimal(){
        return new Animal();
    }

    public static Setter Setter() { return new Setter();}

    @Getter
    public static class Setter {

        private String name = null;

        private int age = 0;

        public Setter withName(String name){
            this.name = name;
            return this;
        }

        public Setter withAge(int age){
            this.age = age;
            return this;
        }

    }
}
