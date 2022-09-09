package com.os;


import java.util.ArrayList;
import java.util.List;

public class AopApplication {

    public static void main(String[] args){
        List<AbstractHandler> handlers = new ArrayList<>();
        handlers.add(new BeforeHandlerImpl());
        handlers.add(new AfterHandlerImpl());

        AccountService proxy = (AccountService) ProxyFactory.getProxy(new AccountServiceImpl(), handlers);
        proxy.addAccount(new Account("hoangnv", "1234"));
        proxy.addAccount(new Account("vanhoang", "1234"));
        proxy.getSize();
        List<Account> accounts = proxy.accountList();
        System.out.println("==========================");
        for(Account account : accounts)
            System.out.println(account.toString());
    }
}
