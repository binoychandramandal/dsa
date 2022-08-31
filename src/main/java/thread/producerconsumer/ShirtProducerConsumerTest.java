package thread.producerconsumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ShirtProducerConsumerTest {
    public static void main(String[] args) {
        Queue<Shirt> store =new ArrayDeque<>();
        int maxSizeOfStore =4;

        Semaphore semaForProducer=new Semaphore(maxSizeOfStore);
        Semaphore semaForConsumer=new Semaphore(0);
        ShirtProducer p1=new ShirtProducer(store,maxSizeOfStore,"p1",semaForProducer,semaForConsumer);
        ShirtProducer p2=new ShirtProducer(store,maxSizeOfStore,"p2",semaForProducer,semaForConsumer);
        ShirtProducer p3=new ShirtProducer(store,maxSizeOfStore,"p3",semaForProducer,semaForConsumer);


        ShirtConsumer c1=new ShirtConsumer(store,"c1",semaForProducer,semaForConsumer);
        ShirtConsumer c2=new ShirtConsumer(store,"c2",semaForProducer,semaForConsumer);
        ShirtConsumer c3=new ShirtConsumer(store,"c3",semaForProducer,semaForConsumer);

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();


        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();

    }
}
