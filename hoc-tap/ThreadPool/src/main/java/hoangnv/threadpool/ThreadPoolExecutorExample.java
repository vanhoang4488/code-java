package hoangnv.threadpool;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) throws InterruptedException {

        final int CORE_POOL_SIZE = 2;

        final int MAX_POOL_SIZE = 4;

        final long KEEP_ALIVE_TIME = 10;

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);

        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNamePrefix("hoangnv-ThreadPool")
                .setDaemon(false)
                .setPriority(Thread.MAX_PRIORITY)
                .setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.err.println(String.format("Custom Exeption: Thread %s throw Exception - %s", t.getName(), e.getMessage()));
                    }
                })
                .build();

        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
                TimeUnit.SECONDS, workQueue, threadFactory, rejectionHandler
        );

        MonitorThread monitor = new MonitorThread(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();

        for(int i = 1; i <= 10; i++){
            executorPool.execute(new WorkThread("cmd" + i));
        }

        Thread.sleep(30000);

        executorPool.shutdown();

        Thread.sleep(5000);
        monitor.shutdown();
    }
}
