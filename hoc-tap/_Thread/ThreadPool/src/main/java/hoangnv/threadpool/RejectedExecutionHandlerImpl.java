package hoangnv.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

// Cài đặt RejectedExecutionHandler để xử lý các tác vụ bị từ chối.
public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor){
        System.out.println(r.toString() + "is rejected");
    }
}
