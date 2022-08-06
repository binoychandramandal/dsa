package thread.executors;

import thread.PrintUsingThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 100; i++) {
            if (i==4 || i==8 || i==15 || i == 50) {
                System.out.println("Wait");
            }
            PrintUsingThread.MyTask task = new PrintUsingThread.MyTask(i);
            executor.execute(task);
        }
        executor.shutdown();

    }
}
