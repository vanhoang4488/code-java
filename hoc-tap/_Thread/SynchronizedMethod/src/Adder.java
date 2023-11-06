public class Adder {
    public int[] array;
    private int sum;
    private int index;
    private int noOfThread = 10;
    private int threadQuit;

    public Adder () {
        this.threadQuit = 0;
        this.index = 0;
        this.array = new int[1000];
        initializeArray();
        startThread();
    }

    public void initializeArray () {
        for (int i = 0; i < 1000; i++) {
            array[i] = i;
        }
    }

    public void startThread() {
        for (int i = 0; i < 10; i++) {
            AdderThread adderThread = new AdderThread(this, i);
            adderThread.start();
        }
    }

    public synchronized  int getIndex () {
        if (index < 1000) return this.index++;
        else return -1;
    }
}
