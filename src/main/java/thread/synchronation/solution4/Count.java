package thread.synchronation.solution4;

public class Count {
    private volatile int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public synchronized void incrementValue(int offset){
        int currentValue =this.value;
        int nextValue =currentValue+offset;
        this.value=nextValue;
    }
}
