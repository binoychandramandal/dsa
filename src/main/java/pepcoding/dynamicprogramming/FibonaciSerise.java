package pepcoding.dynamicprogramming;

public class FibonaciSerise {

    public static void main(String[] args) {
        int n=10;
        System.out.println(fib(n,new int[n+1]));
    }

    /**
     * Memozation method or top down
     * @param n
     * @param memo
     * @return
     */
    static int fib(int n,int[] memo){
        if(n<=1){
            return n;
        }
        if(memo[n]!=0){
            return memo[n];
        }
        int f = fib(n-1,memo)+fib(n-2,memo);
        memo[n]=f;
        return memo[n];
    }
}
