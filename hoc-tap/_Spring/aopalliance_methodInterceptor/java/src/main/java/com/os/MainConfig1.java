package com.os;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

@Configuration
public class MainConfig1 {
    //Register target object
    @Bean
    public Service1 service1() {
        return new Service1();
    }

    //Register a pre notification
    @Bean
    public MethodBeforeAdvice beforeAdvice() {
        MethodBeforeAdvice advice = new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
                System.out.println("Ready to call:" + method);
            }
        };
        return advice;
    }

    //Register a post notification
    @Bean
    public MethodInterceptor costTimeInterceptor() {
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                long starTime = System.nanoTime();
                Object result = invocation.proceed();
                long endTime = System.nanoTime();
                System.out.println(invocation.getMethod() + ",time consuming(nanosecond): " + (endTime - starTime));
                return result;
            }
        };
        return methodInterceptor;
    }

    //Register ProxyFactoryBean
    @Bean
    public ProxyFactoryBean service1Proxy() {
        //1. Create ProxyFactoryBean
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        //2. Set the bean name of the target object
        proxyFactoryBean.setTargetName("service1");
        //3. Set the bean name list of the interceptor. Here are 2 (advice1 and advice2)
        proxyFactoryBean.setInterceptorNames("beforeAdvice", "costTimeInterceptor");
        return proxyFactoryBean;
    }
}