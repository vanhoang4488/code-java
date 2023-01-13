package com.os;


import java.util.List;

public interface AccountService {

    // joinpoint
    void addAccount(Account account);
    // joinpoint
    void removeAccount(Account account);
    // joinpoint
    int getSize();
    // joinpoint
    List<Account> accountList();
}
