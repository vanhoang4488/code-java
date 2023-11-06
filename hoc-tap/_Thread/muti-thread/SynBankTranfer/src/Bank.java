public class Bank {
    private final static int NTEST = 1000;
    private int accounts[];
    private int numTransacts;

    public Bank (int maxAccount, int initBalance) {
        this.numTransacts = 0;
        this.accounts = new int[maxAccount];
        for (int i = 0; i < this.accounts.length; i++) {
            accounts[i] = initBalance;
        }
    }

    public synchronized void transfer(int from, int to, int amount) throws InterruptedException {
        while (this.accounts[from] < amount) wait();
        this.accounts[from] -= amount;
        this.accounts[to] += amount;
        this.numTransacts++;
        notifyAll();
        if (this.numTransacts % NTEST == 0) this.test();
    }

    public void test() {
        int sum = 0;
        for (int i = 0; i < this.accounts.length; i++) {
            sum += accounts[i];
        }
        System.out.printf("Giao dich: %d tong tien %d\n", this.numTransacts, sum);
    }

    public int getSize() {
        return this.accounts.length;
    }
}
