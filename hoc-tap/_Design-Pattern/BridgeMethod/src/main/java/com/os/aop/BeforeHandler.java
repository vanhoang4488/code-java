package com.os.aop;

import java.lang.reflect.Method;

public abstract class BeforeHandler extends AbstractHandler{

    public abstract void beforeHandler();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeHandler();
        return method.invoke(this.getTarget(), args);
    }
}
