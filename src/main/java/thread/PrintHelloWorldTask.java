package thread;

public class PrintHelloWorldTask implements Runnable{

    private int counter;

    public PrintHelloWorldTask(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Hello World "+counter++);
    }
}
