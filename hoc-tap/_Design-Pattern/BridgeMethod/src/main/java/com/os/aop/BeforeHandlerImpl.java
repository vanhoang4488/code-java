package com.os.aop;

public class BeforeHandlerImpl extends BeforeHandler{

    @Override
    public void beforeHandler() {
        System.out.println("before handler:");
    }
}
