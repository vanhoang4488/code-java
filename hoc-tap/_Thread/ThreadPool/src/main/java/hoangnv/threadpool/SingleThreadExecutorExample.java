package hoangnv.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {

    public static void main(String[] args){

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for(int i = 1; i <= 10; i++){
            Runnable work = new WorkThread("" + i);
            executor.execute(work);
        }

        executor.shutdown();

        while( !executor.isTerminated()){
            // Running...
        }

        System.out.println("Finished all threads");
    }
}
