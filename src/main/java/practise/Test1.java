package practise;

public class Test1 {
    public static void main(String[] args) {
        printDecreasingOrder(5);
        System.out.println();
        printIncreasingOrder(5);
        System.out.println();
        printIncreasingDecreasing(5);
        System.out.println();
        System.out.println("factorial");
        System.out.println(fact(4));
        System.out.println();
        System.out.println(pow(2, 3));
        System.out.println(pow(-2, 3));
        System.out.println(pow(-2, 4));
        System.out.println(pow(0, 3));
        System.out.println(pow(1, 0));
        System.out.println(powLogarithm(2, 3));
        System.out.println(powLogarithm(-2, 3));
        System.out.println(powLogarithm(-2, 4));
        System.out.println(powLogarithm(0, 3));
        System.out.println(powLogarithm(1, 0));
        toh(3,'A','B','C');
    }

    static void toh(int n,char a,char b,char c){
        if(n==0){
            return;
        }

        toh(n-1,a,c,b);
        System.out.println(n+"->"+a+" -> "+c);
        toh(n-1,b,a,c);
    }

    static void printDecreasingOrder(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printDecreasingOrder(n - 1);
    }

    static void printIncreasingOrder(int n) {
        if (n == 0) {
            return;
        }
        printIncreasingOrder(n - 1);
        System.out.print(n + " ");
    }

    static void printIncreasingDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printIncreasingDecreasing(n - 1);
        System.out.print(n + " ");
    }

    static int fact(int n) {
        return n == 1 ? 1 : n * fact(n - 1);
    }

    static int pow(int x, int y) {
        if (x == 0) {
            return 0;
        }
        if (y == 0) {
            return 1;
        }

        return x * pow(x, y - 1);
    }

    static int powLogarithm(int x, int y) {
        if (x == 0)
            return 0;
        if (y == 0) {
            return 1;
        }
        int half = powLogarithm(x, y / 2);
        int evenResult = half * half;
        return y % 2 == 0 ? evenResult : x * evenResult;
    }
}
