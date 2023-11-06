package base;

import annotation.Bean;

@Bean(name = "cat")
public class Cat extends Animal{

    public String toString() {
        return "Cat";
    }
}
