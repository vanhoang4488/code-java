package com.os;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService{

    private List<Account> accounts;

    public AccountServiceImpl(){
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account){
        System.out.println("Account: " + account.toString());
        this.accounts.add(account);
    }

    public void removeAccount(Account account){
        System.out.println("Account: " + account.toString());
        this.accounts.remove(account);
    }

    public int getSize(){
        System.out.println("Size: " + this.accounts.size());
        return this.accounts.size();
    }

    public List<Account> accountList(){
        return accounts;
    }
}
