package com.os.aop.JdkProxy;

import com.os.aop.Account;
import com.os.aop.JdkProxy.AccountService;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService<Account> {

    private List<Account> list;

    public AccountServiceImpl(){
        list = new ArrayList<>();
    }

    public void add(Account account){

        System.out.println("add account: " + account.toString());
    }

    public void remove(Account account){
        list.remove(account);
        System.out.println("remove account: " + account.toString());
    }

    /**
     * phương thức này không nằm trong proxy, theo JDK dynamic proxy.
     * @param account
     */
    public void display(Account account){
        System.out.println("this is account");
    }
}
