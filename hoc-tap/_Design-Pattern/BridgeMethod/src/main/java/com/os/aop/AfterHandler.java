package com.os.aop;

import java.lang.reflect.Method;

public abstract class AfterHandler extends AbstractHandler{

    public abstract void afterHandler();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.getTarget(), args);
        afterHandler();
        return result;
    }
}
