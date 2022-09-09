package solution;

public class TransferThread implements Runnable{
    private Bank bank;
    private int from;
    private int to;

    public TransferThread(Bank bank, int from, int to){
        this.bank = bank;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        try {
            bank.transfer(from, to, 100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
