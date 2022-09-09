package com.os.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectHandler {

    @Pointcut("execution(* com.os.controller.*.*(..))")
    public void beforeController(){}

    @Before("beforeController()")
    public void setJoinPoint(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("-------------->>> hello!!");
    }
}
