package solution;

public class Bank {

    private int[] accounts;

    public Bank(int accSize, int accMoney){
        this.accounts = new int[accSize];
        for(int i = 0; i < accSize; i++)
            accounts[i] = accMoney;
    }

    public synchronized void transfer(int from, int to, int amount) throws InterruptedException {
        for(int i = 0; i < 1; i++) System.out.println("---------");
        if (this.accounts[from] < amount) wait();

        accounts[from] -= amount;
        accounts[to] += amount;
        System.out.println("end");
    }

    public void display(int from){
        System.out.println("====> money in acc: " + this.accounts[from]);
    }

    public void total(int from, int amount){
        this.accounts[from] -= amount;
        System.out.println("++++++++++++");
    }
}
