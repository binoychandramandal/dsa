package dsa.level1;

public class Fibonacci {
    public static void main(String[] args) {
       printFib(10);
    }

    static void printFib(int n){
        int a=0;
        int b=1;
        for (int i = 0; i < n; i++) {
            System.out.println(a);
            int c=a+b;
            a=b;
            b=c;
        }
    }
}
