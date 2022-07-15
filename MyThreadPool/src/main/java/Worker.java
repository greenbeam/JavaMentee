import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {

    private BlockingQueue<Runnable>  queue;

    private volatile boolean shutDown = false;

    public boolean isShutDown() {
        return shutDown;
    }

    public void setShutDown(boolean shutDown) {
        this.shutDown = shutDown;
    }


    public Worker(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (!shutDown) {
            try {
                Runnable task = this.queue.take();
                System.out.println("Thread:"+Thread.currentThread().getName() + " for " +((Employee) task).getName());
                task.run();
            } catch (InterruptedException e) {
                System.out.println("Exception in running threads");
            }
        }
    }

}
