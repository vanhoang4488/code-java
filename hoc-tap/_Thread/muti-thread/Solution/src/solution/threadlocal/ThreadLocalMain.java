package solution.threadlocal;

public class ThreadLocalMain {

    public static final ThreadLocal<String> THREAD_LOCAL =  new ThreadLocal<>();

    public static void main(String[] args){

        Thread thread = new Thread(new ExecutorThread());
        thread.start();
        System.out.println(THREAD_LOCAL.get());
    }
}
