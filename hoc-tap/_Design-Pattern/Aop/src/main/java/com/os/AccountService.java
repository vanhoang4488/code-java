package com.os;


import java.util.List;

public interface AccountService {

    void addAccount(Account account);
    void removeAccount(Account account);
    int getSize();
    List<Account> accountList();
}
