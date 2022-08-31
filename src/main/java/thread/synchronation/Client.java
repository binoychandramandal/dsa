package thread.synchronation;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        Count count = new Count();
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(adder);
        executor.execute(subtractor);
        try{
            executor.awaitTermination(10, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count.getValue());
    }
}
