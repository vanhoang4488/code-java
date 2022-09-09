package com.os.aop;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Objects;

public class ProxyFactory {

    private ProxyFactory(){}

    public static Object getProxy(Object target, List<AbstractHandler> handlers){
        if(!Objects.isNull(target) && !handlers.isEmpty()){
            Object proxy = target;
            for(AbstractHandler handler : handlers){
                handler.setTarget(proxy);
                proxy = Proxy
                        .newProxyInstance(
                                proxy.getClass().getClassLoader(),
                                proxy.getClass().getInterfaces(), handler);
            }
            return proxy;
        }
        return null;
    }
}
