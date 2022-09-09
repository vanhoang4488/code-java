package hoangnv.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

// Tạo lớp ThreadFactoryBuilder để tùy chỉnh ThreadFactory trong việc
// đặt tên Thread, xử lý ngoại lệ, xác định độ ưu tiên của Thread, xác định luồng daemon.
public class ThreadFactoryBuilder {

    private String namePrefix;
    private boolean daemon;
    private int priority = Thread.NORM_PRIORITY;
    private ThreadFactory backingThreadFactory;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    public ThreadFactoryBuilder() {}

    public ThreadFactoryBuilder setNamePrefix(String prefix){
        if(prefix == null)
            throw new NullPointerException();
        this.namePrefix = prefix;
        return this;
    }

    public ThreadFactoryBuilder setDaemon(boolean daemon){
        this.daemon = daemon;
        return this;
    }

    public ThreadFactoryBuilder setPriority(int priority){

        if(priority < Thread.MIN_PRIORITY)
            throw new IllegalArgumentException("Priority >= 1");
        if(priority > Thread.MAX_PRIORITY)
            throw  new IllegalArgumentException("Priority <= 10");

        this.priority = priority;
        return this;
    }

    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler){
        if(null == uncaughtExceptionHandler)
            throw new NullPointerException();
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        return this;
    }

    public ThreadFactoryBuilder setThreadFactory(ThreadFactory threadFactory){
        if(null == threadFactory)
            throw new NullPointerException();
        this.backingThreadFactory = threadFactory;
        return this;
    }

    public ThreadFactory build(){
        return build(this);
    }

    private static ThreadFactory build(ThreadFactoryBuilder builder){

        final String namePrefix = builder.namePrefix;
        final Boolean daemon = builder.daemon;
        final Integer priority = builder.priority;
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = builder.uncaughtExceptionHandler;
        final ThreadFactory backingThreadFactory = (builder.backingThreadFactory != null)?builder.backingThreadFactory: Executors.defaultThreadFactory();

        final AtomicLong count = new AtomicLong(0);

        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = backingThreadFactory.newThread(r);
                if(namePrefix != null)
                    thread.setName(namePrefix + "-" + count.getAndIncrement());
                if(daemon != null)
                    thread.setDaemon(daemon);
                if(priority != null)
                    thread.setPriority(priority);
                if(uncaughtExceptionHandler != null)
                    thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                return thread;
            }
        };
    }
}
