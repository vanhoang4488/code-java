package com.os;

import java.lang.reflect.Method;

// aspect
public  abstract class AfterHandler extends AbstractHandler{

    public static int count = 0;

    public abstract void handleAfter();

    // advice
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(getTargetObject(), args);
        handleAfter();
        return result;
    }
}
