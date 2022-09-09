package solution.threadlocal;

public class ExecutorThread implements Runnable{

    @Override
    public void run() {
        ThreadLocalMain.THREAD_LOCAL.set("hoangnv");
    }
}
