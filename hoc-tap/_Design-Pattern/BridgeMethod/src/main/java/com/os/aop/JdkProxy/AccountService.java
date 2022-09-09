package com.os.aop.JdkProxy;

public interface AccountService<T>{

    void add(T account);
    void remove(T account);
}
