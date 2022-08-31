package thread.synchronation.solution3;

public class Adder implements Runnable{
    private Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synchronized (count) {
                count.incrementValue(i);
                //System.out.println("Adder-> "+nextValue);
            }
        }
    }
}
