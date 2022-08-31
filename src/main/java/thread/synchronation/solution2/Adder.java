package thread.synchronation.solution2;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synchronized (count) {
                int currentValue = count.getValue();
                int nextValue = currentValue + 1;
                count.setValue(nextValue);
                //System.out.println("Adder-> "+nextValue);
            }
        }
    }
}
