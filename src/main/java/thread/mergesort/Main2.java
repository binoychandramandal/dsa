package thread.mergesort;

public class Main2 {

    static class Walmart{
        public void print(){
            System.out.println("Wlamart's print()");
        }
    }

    class FlipCart extends Walmart{
        public void print(){
            System.out.println("Flipcart's print()");
        }
    }

    class Myntra extends FlipCart{
        public void print(){
            //super.super.print();
            System.out.println("Flipcart's print()");
        }
    }

    public static void main(String[] args) {

        switch ("abcde".charAt(0)){
            case 'a':
                System.out.println("a");

            case 'b':
                System.out.println("b");
        }
    }
}
