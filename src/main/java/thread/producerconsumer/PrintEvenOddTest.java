package thread.producerconsumer;

import java.util.concurrent.Semaphore;

public class PrintEvenOddTest {
    public static void main(String[] args) {
        final PrintEvenOdd p = new PrintEvenOdd();
        final Semaphore even = new Semaphore(1);
        final Semaphore odd = new Semaphore(0);

        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(100);
                    even.acquire();
                    p.printEven();
                    odd.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(100);
                    odd.acquire();
                    p.printEven();
                    even.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
