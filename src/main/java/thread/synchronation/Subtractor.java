package thread.synchronation;

public class Subtractor implements Runnable{
    private Count count;

    public Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            int currentValue = count.getValue();
            try {
                Thread.sleep(2);
            }catch (Exception e){
                e.printStackTrace();
            }
            int nextValue =currentValue-1;
            count.setValue(nextValue);
        }
    }
}
