package thread;

public class PrintHelloWorldTaskRunner {
    public static void main(String[] args) {
        PrintHelloWorldTask phw= new PrintHelloWorldTask(1);
        Thread th=new Thread(phw);
        th.start();

        Thread th1=new Thread(phw);
        th1.start();
        System.out.println("Done");
    }
}
