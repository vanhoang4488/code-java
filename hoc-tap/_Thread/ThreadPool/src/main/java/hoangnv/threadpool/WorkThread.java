package hoangnv.threadpool;

/**
 *
 * @author hoang
 */
public class WorkThread implements Runnable{

    private String task;
    
    public WorkThread(String s){
        this.task = s;
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Starting. Task = " + task);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " Finished: Task = " + task);
    }

    private void processCommand(){
        try{
            Thread.sleep(100);
        } catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "" + task + " ";
    }
}
