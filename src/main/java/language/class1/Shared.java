package language.class1;

public class Shared {

    private int max;
    volatile int start=1;

    public Shared(int max) {
        this.max = max;
    }
    boolean isThreshHoldReached(){
        return start>max;
    }

    boolean isOdd(){
        return start%2==0?true:false;
    }

    void print(){
        System.out.println(start+" -> "+Thread.currentThread().getName());
    }

    void increment(){
        start++;
    }

   synchronized void printOdd() throws InterruptedException {
        if(!isThreshHoldReached()) {
            if(isOdd()){
                print();
                increment();
                notify();
            }else{
                wait();
            }
        }
    }

   synchronized void printEven() throws InterruptedException {
        if(!isThreshHoldReached()) {
            if(!isOdd()){
                print();
                increment();
                notify();
            }else{
                wait();
            }
        }
    }

}
