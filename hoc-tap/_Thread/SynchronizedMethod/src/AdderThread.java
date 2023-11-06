public class AdderThread extends Thread{

    private int sum;
    private Adder adder;
    private int index;

    public AdderThread(Adder adder, int index) {
        this.adder = adder;
        this.index = index;
    }

    @Override
    public void run() {
        this.sum = 0;
        int i = 0;
        while (i != -1) {
            sum += this.adder.array[i];
            i = this.adder.getIndex();
        }

        System.out.printf("Thread %s tinh duoc tong: %d\n", this.index, this.sum);
    }
}
