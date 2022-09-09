/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synbanktransfer;

/**
 *
 * @author hoang
 */
public class SynBankTransfer {

    /**
     * @param args the command line arguments
     */
    public static final int NACCOUNTS = 10;
    public static final int INI_BALANCE = 10000;
    
    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS, INI_BALANCE);
        for(int i = 0; i < NACCOUNTS; i++){
            TransferThread t = new TransferThread(b, i, INI_BALANCE);
            t.setPriority(Thread.NORM_PRIORITY + i%2);
            t.start();
        }
    }
    
}
