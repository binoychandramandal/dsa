package pepcoding.dynamicprogramming;

public class FibonaciSerise {

    public static void main(String[] args) {
        int n=10;
        System.out.println(f(n));
        System.out.println(f1(n));
        System.out.println(fib(n,new int[n+1]));
    }

    static int f1(int n){
        if(n<=1) return n;
        int[] dp =new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    static int f(int n){
        if(n<=1){
            return n;
        }
        return f(n-1)+f(n-2);
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
