package thread.producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ShirtProducer implements Runnable {
    private Queue<Shirt> store;
    private int maxSize;
    private String name;
    private Semaphore semaForProducer;
    private Semaphore semaForConsumer;

    public ShirtProducer(Queue<Shirt> store, int maxSize, String name, Semaphore semaForProducer,Semaphore semaForConsumer) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.semaForProducer = semaForProducer;
        this.semaForConsumer = semaForConsumer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaForProducer.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                store.add(new Shirt());
                System.out.println(name + " produced");
                semaForConsumer.release();
            }
    }
}
