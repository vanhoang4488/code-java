package com.os;

import java.lang.reflect.Method;

// aspect
public abstract class BeforeHandler extends AbstractHandler{

    public static int count = 0;

    public abstract void handleBefore();

    // advice
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        handleBefore();
        return method.invoke(getTargetObject(), args);
    }
}
