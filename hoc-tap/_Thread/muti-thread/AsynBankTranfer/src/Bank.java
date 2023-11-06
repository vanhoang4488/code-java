public class Bank {
    public final static int NTEST = 1000;
    private int[] accounts;
    private long numTransacts;
    public Bank (int maxAccount, int initBalance) {
        this.numTransacts = 0;
        this.accounts = new int[maxAccount];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initBalance;
        }
    }

    public void transfer (int from, int to, int amount) {
        if (this.accounts[from] < amount) return;
        this.accounts[from] -= amount;
        this.accounts[to] += amount;
        this.numTransacts++;
        if (numTransacts % NTEST == 0) this.test();
    }

    public void test() {
        int sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            sum += accounts[i];
        }
        System.out.printf("Giao dich: %d tong so %d\n", this.numTransacts, sum);
    }

    public int getSize() {
        return this.accounts.length;
    }
}
