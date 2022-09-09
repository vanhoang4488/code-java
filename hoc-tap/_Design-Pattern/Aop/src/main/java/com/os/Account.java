package com.os;

public class Account {

    private String username;
    private String password;

    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String toString(){
        return "user: " + this.username + ", password: " + this.password;
    }
}
