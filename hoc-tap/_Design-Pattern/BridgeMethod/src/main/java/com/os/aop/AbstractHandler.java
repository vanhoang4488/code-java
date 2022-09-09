package com.os.aop;

import lombok.Data;

import java.lang.reflect.InvocationHandler;

@Data
public abstract class AbstractHandler implements InvocationHandler {

    private Object target;
}
