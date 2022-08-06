package language.class1;

public class Test {
    public static void main(String[] args) {
        final Shared s = new Shared(10);
       new Thread(()->{
           while (!s.isThreshHoldReached()){
               try {
                   s.printEven();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       },"Even").start();
       new Thread(()->{
           while (!s.isThreshHoldReached()){
               try {
                   s.printOdd();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       },"Odd").start();

    }



}
