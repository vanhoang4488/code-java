public class TransferThread extends Thread{
    private Bank bank;
    private int fromAcc;
    private int maxAmount;

    public TransferThread(Bank bank, int from, int maxAmount) {
        this.bank = bank;
        this.fromAcc = from;
        this.maxAmount = maxAmount;
    }

    @Override
    public void run() {
        try{
            while (!interrupted()) {
                int to = (int) (this.bank.getSize() * Math.random());
                int amount = (int) (this.maxAmount * Math.random());
                this.bank.transfer(fromAcc, to, amount);
                sleep(1);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
