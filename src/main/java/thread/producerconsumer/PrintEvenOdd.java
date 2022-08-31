package thread.producerconsumer;

public class PrintEvenOdd {
    int i = 0;

    public void printEven() {
        System.out.println(++i);
    }

    public void printOdd() {
        System.out.println(++i);
    }


}
