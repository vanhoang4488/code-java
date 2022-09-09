package com.os.aop;

public class AfterHandlerImpl extends AfterHandler{

    @Override
    public void afterHandler() {
        System.out.println("after handler: ");
        System.out.println("----------------");
    }
}
