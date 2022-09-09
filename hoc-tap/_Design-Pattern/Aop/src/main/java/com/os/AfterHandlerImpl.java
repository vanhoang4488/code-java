package com.os;

public class AfterHandlerImpl extends AfterHandler{

    private int id = 0;

    public AfterHandlerImpl(){count++; id = count;}

    @Override
    public void handleAfter() {
        System.out.println("===> After handler: " + id);
        System.out.println("---------");
    }
}
