package thread.mergesort;

import java.util.List;

public class Main {

    private static Object executor1 = new Object();
    private static Object executor2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (executor1){
                System.out.println(Thread.currentThread()+"get Executor1");
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"Waiting get execuor2");
                synchronized (executor2){
                    System.out.println(Thread.currentThread()+"Get executor 2");
                }
            }

        }, "Thread").start();

        new Thread(() -> {
            synchronized (executor1){
                System.out.println(Thread.currentThread()+"get Executor1");
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"Waiting get execuor2");
                synchronized (executor2){
                    System.out.println(Thread.currentThread()+"Get executor 2");
                }
            }

        }, "Thread").start();
    }
}
