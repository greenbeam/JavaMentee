import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;


public class MyThreadPool {

    private BlockingQueue<Runnable> queue;
    private List<Worker> workers;

    public long WAIT_TIMEOUT = 3000;

    @lombok.SneakyThrows
    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(3);

		for (int i=0; i<3; i++) {
		    pool.submit(new Employee(String.valueOf(i),i));
        }
		pool.shutDown();

    }

    public MyThreadPool(int size) {
        this.queue = new ArrayBlockingQueue<>(size);
        this.workers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Worker w = new Worker(this.queue);
            this.workers.add(w);
            Thread t = new Thread(w);
            t.start();
        }
    }

    public void submit(Runnable task) {
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            System.out.println("Put failed");
        }
    }

    public void shutDown() throws InterruptedException {
        while (!this.queue.isEmpty()) {
            wait(WAIT_TIMEOUT);
        }
        for (int i = 0; i < workers.size(); i++) {
            workers.get(i).setShutDown(true);
        }
        System.out.println("Shutdown completed");
    }

}
