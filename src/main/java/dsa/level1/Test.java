package dsa.level1;

public class Test {
    public static void main(String[] args) {
        int n = 100;
        printLeftToRight(n);
        System.out.println(reverse(123));
    }

    static int reverse(int n){
        int reverse=0;
        while (n>0){
            reverse=reverse*10+(n%10);
            n/=10;
        }
        return reverse;
    }

    static int countDigit(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    static void printLeftToRight(int n){
        int count = countDigit(n);
        int div = (int)Math.pow(10,count-1);
        while(div!=0){
            System.out.println(n/div);
            n=n%div;
            div/=10;
        }
    }
}
