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
public class TransferThread implements Runnable{

    private Bank bank;
    private int Naccounts;
    private int balance;
    private int fromAcc;
    
    public TransferThread(Bank bank, int fromAcc, int Naccounts, int balance){
        this.bank = bank;
        this.fromAcc = fromAcc;
        this.Naccounts = Naccounts;
        this.balance = balance;
    }
    
    @Override
    public void run() {
        try{
            while(!Thread.currentThread().isInterrupted()){
            
                int toAcc = (int)(Naccounts * Math.random());
                int amount = (int)(balance * Math.random());
                bank.tranfer(fromAcc, toAcc, amount);
                Thread.currentThread().sleep(2);
            } 
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    
}
