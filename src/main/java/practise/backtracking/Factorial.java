package practise.backtracking;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    static int fact(int n) {
        return n == 0 ? 1 : n * fact(n - 1);
    }


}
