package thread.synchronation.solution;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Count count;
    private Lock lock;

    public Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            lock.lock();
            int currentValue = count.getValue();
            int nextValue =currentValue+1;
            count.setValue(nextValue);
            //System.out.println("Adder-> "+nextValue);
            lock.unlock();
        }
    }
}
