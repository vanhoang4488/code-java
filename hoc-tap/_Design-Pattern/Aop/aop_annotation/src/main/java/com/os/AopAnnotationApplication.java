package com.os;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopAnnotationApplication {

    public static void main(String[] args){
        SpringApplication.run(AopAnnotationApplication.class, args);
    }
}
