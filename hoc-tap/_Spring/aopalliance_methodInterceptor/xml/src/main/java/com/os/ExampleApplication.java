package com.os;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExampleApplication {

    public static void main(String[] args){

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Bank bank = (Bank) context.getBean("proxy");
        bank.deposit(500, "XYZ123");

        context.close();
    }
}
