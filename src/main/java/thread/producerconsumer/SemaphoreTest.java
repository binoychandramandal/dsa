package thread.producerconsumer;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        Semaphore s=new Semaphore(0);
        for (int i=0;i<10;i++){
            s.acquire();
            System.out.println(i+" pricessing");
        }
        System.out.println("Waiting");
    }
}
