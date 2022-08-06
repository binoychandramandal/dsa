package thread.producerconsumer;

public class SharedResource {

    private int counter=0;

    public SharedResource(int counter) {
        this.counter = counter;
    }

    public void incrementAndPrint(){
        System.out.println(++counter);
    }
}
