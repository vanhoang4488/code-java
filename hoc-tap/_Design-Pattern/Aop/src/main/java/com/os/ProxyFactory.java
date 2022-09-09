package com.os;

import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory {

    private ProxyFactory() {}

    public static Object getProxy(Object targetObject, List<AbstractHandler> handlers){
        if(handlers != null && !handlers.isEmpty()){
            Object proxyObject = targetObject;
            for(AbstractHandler handler : handlers){
                handler.setTargetObject(proxyObject);
                proxyObject =
                        Proxy.
                                newProxyInstance(
                                        targetObject.getClass().getClassLoader(),
                                        targetObject.getClass().getInterfaces(),
                                        handler);
            }
            return proxyObject;
        }
        else throw new RuntimeException("handlers null or empty");
    }
}
