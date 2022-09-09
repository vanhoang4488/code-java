package com.os.aop;

import com.os.aop.JdkProxy.AccountService;
import com.os.aop.JdkProxy.AccountServiceImpl;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AopAndBridgeMethodMain {

    public static void main(String[] args) throws NoSuchMethodException {
        List<AbstractHandler> handlers = new ArrayList<>();
        handlers.add(new BeforeHandlerImpl());
        handlers.add(new AfterHandlerImpl());

        AccountServiceImpl targetClass = new AccountServiceImpl();
        AccountService proxy = (AccountService) ProxyFactory.getProxy(targetClass, handlers);
        proxy.add(new Account("hoangnv", "123"));
        Method method = proxy.getClass().getDeclaredMethod("display", new Class[]{Account.class});
        System.out.println("method: " + method.toString());
        System.out.println("method is bridge method: " + method.isBridge());
        Method specifiedMethod = ClassUtils.getMostSpecificMethod(method, targetClass.getClass());
        System.out.println("specified method: " + specifiedMethod.toString());
        System.out.println("specified method is bridge method: " + specifiedMethod.isBridge());
        Method bridgeMethod = BridgeMethodResolver.findBridgedMethod(specifiedMethod);
        System.out.println("bridge method: " + bridgeMethod.toString());
        System.out.println("bridgeMethod is bridge method: " + bridgeMethod.isBridge());
    }
}
