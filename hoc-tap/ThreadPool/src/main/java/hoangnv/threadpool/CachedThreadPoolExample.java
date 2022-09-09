package hoangnv.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {

    public static void main(String[] args) throws InterruptedException{

        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 1; i <= 10; i++){
            Runnable work = new WorkThread("" + i);
            executor.execute(work);
        }

        executor.shutdown();

        while(!executor.isTerminated()){
            // Running...
        }

        System.out.println("Finished all threads");
    }
}
