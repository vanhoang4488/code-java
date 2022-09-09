package com.os.aop.CGLIB;

import com.os.aop.Account;

import java.util.ArrayList;
import java.util.List;

public class BaseAccountService extends BaseService{

    private List<Account> list;

    public BaseAccountService(){
        list = new ArrayList<>();
    }

    public void addAccount(Account account){
        list.add(account);
    }
}
