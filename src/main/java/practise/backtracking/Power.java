package practise.backtracking;

public class Power {
    public static void main(String[] args) {
        System.out.println(pow(2, 3));
        System.out.println(powLogarithm(2, 3));
    }

    static int pow(int x, int y) {
        return y == 0 ? 1 : x * pow(x, y - 1);
    }

    static long powLogarithm(int x, int y) {
        if (y == 0) return 1;
        long halfPow = powLogarithm(x, y / 2);
        long result = halfPow * halfPow;
        return y%2==0?result:x*result;
    }


}
