package com.os;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProxyFactoryBeanApplication {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainConfig1.class);
        //Get the proxy object. The name of the proxy object bean is the name of the registered ProxyFactoryBean, that is, service1Proxy
        Service1 bean = context.getBean("service1Proxy", Service1.class);
        System.out.println("----------------------");
        //Method of calling proxy
        bean.m1();
        System.out.println("----------------------");
        //Method of calling proxy
        bean.m2();
    }
}
