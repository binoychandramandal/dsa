package pepcoding.dynamicprogramming;

public class FriendPairing {
    public static void main(String[] args) {
        System.out.println(pairCount(5));
    }

    static int pairCount(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] * (i - 1);
        }
        return dp[n];
    }
}
