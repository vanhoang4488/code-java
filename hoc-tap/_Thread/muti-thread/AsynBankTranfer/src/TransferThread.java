public class TransferThread extends Thread{
    private Bank bank;
    private int fromAcc;
    private int maxAmount;

    public TransferThread (Bank bank, int from, int max) {
        this.bank = bank;
        this.fromAcc = from;
        this.maxAmount = max;
    }

    @Override
    public void run() {
        try {
            while (!interrupted()) {
                int toAcc = (int) (this.bank.getSize() * Math.random());
                int amount = (int) (this.maxAmount * Math.random());
                bank.transfer(fromAcc, toAcc, amount);
                sleep(1);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
