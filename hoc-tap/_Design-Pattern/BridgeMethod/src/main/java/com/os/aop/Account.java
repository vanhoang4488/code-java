package com.os.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private String username;
    private String password;

    public String toString(){
        return "username: " + this.username + ", password: " + this.password;
    }
}
