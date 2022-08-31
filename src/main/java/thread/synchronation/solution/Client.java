package thread.synchronation.solution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    /**
     * Using shared lock we can prevent race condition
     *
     * @param args
     */
    public static void main(String[] args) {
        Count count = new Count();
        Lock lock = new ReentrantLock();
        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(adder);
        executor.execute(subtractor);
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count.getValue());
    }
}
