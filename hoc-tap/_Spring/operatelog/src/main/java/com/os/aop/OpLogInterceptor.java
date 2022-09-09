package com.os.aop;

import com.os.entity.Circle;
import com.os.entity.ResultEntity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;

@Data
@Slf4j
public class OpLogInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        System.out.println("===> origin class: " + invocation.getThis().getClass().getName());
        return execute(invocation, invocation.getThis(), method, invocation.getArguments());
    }

    private Object execute(MethodInvocation invocation, Object target, Method method, Object[] args){
        Class<?> targetClass = this.getTargetClass(target);
        System.out.println("===> targetClass: " + targetClass.getName());
        Object result = null;
        Throwable ex = null;

        try {
            result = invocation.proceed();
        }catch (Throwable exception) {
            ex = exception;
        }

        // chỉ xét các phương thức có mức truy cập public.
        if(!Modifier.isPublic(method.getModifiers()))
            return null;

        if(!Objects.isNull(result)) {
            ResultEntity resultEntity = (ResultEntity) result;
            ServletRequestAttributes requestAttributes =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
           HttpServletRequest request = null;
            if(!Objects.isNull(requestAttributes))
                request = requestAttributes.getRequest();

            if(resultEntity.isOk() && !Objects.isNull(request)){
                System.out.println("===> method: " + method.toString());
                System.out.println(method.isBridge());
                Method specificMethod = ClassUtils.getMostSpecificMethod(method, targetClass);
                System.out.println("===> specifiedMethod: " + specificMethod.toString());
                System.out.println(specificMethod.isBridge());
                specificMethod = BridgeMethodResolver.findBridgedMethod(specificMethod);
                System.out.println("===> bridgeMethod: " + specificMethod.toString());
                System.out.println(specificMethod.isBridge());
            }
        }

        if(ex != null)
            return ex;
        return result;
    }

    private Class<?> getTargetClass(Object target) { return AopProxyUtils.ultimateTargetClass(target);}

}
