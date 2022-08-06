package language.class1;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadSequentialPrint {

    public static void main(String[] args) throws InterruptedException {

        new FanInFanOut(50).execute();


    }

    static class FanInFanOut {

        List<Integer> items;
        List<Thread> threads;
        public FanInFanOut(int num) {
            items = new ArrayList<>(num);
            threads = new ArrayList<>(4);
            for (int j = 1; j <= 50; j++) {
                items.add(j);
            }
        }

        void print(int index) {
            System.out.println(items.get(index-1) + " -> " + Thread.currentThread().getName());
        }

        void increment(int[] i) {
            synchronized (i) {
                if (i[0] <= 40) {
                    print(i[0]);
                    i[0]++;
                }
            }
        }

        public void execute() throws InterruptedException {
            final int[] i = {1};
            while (i[0] <= 10) {
                print(i[0]);
                i[0]++;
            }

            for (int j = 0; j < 4; j++) {
                threads.add(new Thread(() -> {
                    while (i[0]<=40) {
                       increment(i);
                    }
                }));
            }

            threads.forEach(Thread::start);
            for (Thread t : threads) {
                t.join();
            }

            while (i[0] <= 50) {
                print(i[0]);
                i[0]++;
            }
        }


    }
}
