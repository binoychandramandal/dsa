package thread;

public class PrintUsingThread {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
              Thread t=new Thread(new MyTask(i));
              t.start();
        }
    }

   public  static class MyTask implements Runnable{
        private int counter;

        public MyTask(int counter) {
            this.counter = counter;
        }

        public void print(){
            System.out.println(Thread.currentThread().getName()+" : "+counter);
        }

        @Override
        public void run() {
            print();
        }
    }
}
