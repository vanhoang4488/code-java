package synbanktransfer;

public class TransferThread extends Thread{
    private Bank bank;
    private int fromAcc;
    private int maxAmount;
    
    public TransferThread(Bank b, int from, int max){
        bank = b;
        fromAcc = from;
        maxAmount = max;
    }
    
    public void run(){
        try{
            while(!interrupted()){
                int toAcc = (int) (bank.size() * Math.random());
                int amount = (int) (maxAmount * Math.random());
                bank.transfer(fromAcc, toAcc, amount);
                sleep(1);
            }
        }catch(InterruptedException ex){
            
        }
    }
}
