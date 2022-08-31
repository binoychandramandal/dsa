package thread.producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ShirtConsumer implements Runnable {
    private Queue<Shirt> store;
    private String name;
    private Semaphore semaForProducer;
    private Semaphore semaForConsumer;

    public ShirtConsumer(Queue<Shirt> store, String name, Semaphore semaForProducer, Semaphore semaForConsumer) {
        this.store = store;
        this.name = name;
        this.semaForProducer = semaForProducer;
        this.semaForConsumer = semaForConsumer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaForConsumer.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(store.poll() + " consume " + name);
            semaForProducer.release();
        }

    }
}
