/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synbanktransfer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang
 */
public class Bank {
    public static final int NTEST = 1000;
    private int[] accounts;
    private long numTransacts = 0;
    public Bank(int n, int initBalance){
        accounts = new int[n];
        for(int i = 0; i < accounts.length; i++)
            accounts[i] = initBalance;
        numTransacts = 0;
    }
    
    public synchronized void transfer(int from, int to, int amount){
        while(accounts[from] < amount) try {
            wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
            }
        accounts[from] -= amount;
        accounts[to] += amount;
        numTransacts++;
        notifyAll();
        if(numTransacts % NTEST == 0) test();
    }
    
    private synchronized void test(){
        int sum = 0;
        for(int i = 0; i < accounts.length; i++)
            sum += accounts[i];
        System.out.println("Giao dich: " + numTransacts + " tong so: " + sum);
    }
    
    public int size(){
        return accounts.length;
    }
}
