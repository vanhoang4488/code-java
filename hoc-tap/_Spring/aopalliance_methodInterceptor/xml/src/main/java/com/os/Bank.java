package com.os;

public class Bank {
    private String accountNo = "XYZ123";
    private int amount = 1000;

    public void deposit(int amount, String acNo) {

        if (acNo.equals(this.accountNo)) {

            System.out.println("inside deposit method...");

            this.amount = this.amount + amount;

            System.out.println("Total Balance: " + this.amount);

        } else {
            throw new RuntimeException();
        }
    }
}
