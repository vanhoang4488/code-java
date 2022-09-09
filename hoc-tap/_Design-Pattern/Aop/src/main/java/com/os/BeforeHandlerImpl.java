package com.os;

public class BeforeHandlerImpl extends BeforeHandler{

    private int id = 0;

    public BeforeHandlerImpl(){count++; id = count;}

    @Override
    public void handleBefore() {
        System.out.println("==> Before handler:" + id);
    }
}
