/*
 * Đề bài:
 *  Xây dựng hệ thống ngân hàng có 10 tài khoản trong đó các giao dịch
 *  chuyển tiền giữa các tài khoản với nhau một cách ngẫu nhiên. 
 *  Chương trình tạo 10 luồng cho 10 tài khoản. Mỗi giao dịch được một luồng
 *  phục vụ sẽ chuyển tiền ngẫu nhiên tới một tài khoản khác.
 */

package asynbanktransfer;

/**
 *
 * @author hoang
 */
public class AsynBankTransfer {

    private static final int NACCOUNTS = 10;
    private static final int IN_BALANCE = 10_000;
    
    public static void main(String[] args) {
        
        Bank bank = new Bank(NACCOUNTS, IN_BALANCE);
        
        for(int i = 0; i < NACCOUNTS; i++){
            TransferThread transfer = new TransferThread(bank, i, NACCOUNTS, IN_BALANCE);
            Thread t = new Thread(transfer);
            t.setPriority(Thread.NORM_PRIORITY + i / 2);
            t.start();
        }
        
    }
    
}
