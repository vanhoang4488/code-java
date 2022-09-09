/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asynbanktransfer;

/**
 *
 * @author hoang
 */
public class Bank {
    
    private int[] accounts;
    private int countTransfer = 0;
    private final int NTest = 200;
    private int sum;
    
    public Bank(int length, int money){
        
        accounts = new int[length];        
        for(int i = 0; i < length; i++) 
            accounts[i] = money;        
    }
    
    public synchronized void tranfer(int from, int to, int amount) throws InterruptedException{
        
        while(accounts[from] < amount) wait();
        accounts[from] -= amount;
        accounts[to] += amount;
        countTransfer++;
        sum += amount;
        notifyAll();    
        if(countTransfer == NTest){
           display(); 
           Thread.currentThread().getThreadGroup().stop();
        }    
    }
    
    public void display(){
        
        System.out.print("Số tiền trong mỗi tài khoản còn: ");
        
        for(int i = 0; i < accounts.length; i++)
            System.out.print(accounts[i] + " ");
        
        System.out.println();
        System.out.printf("Số giao dịch: %d trên số tiền: %d\n", countTransfer, sum);
    }

    public int getCountTransfer() {
        return countTransfer;
    }

    public int getNTest() {
        return NTest;
    }
        
}
