package dynamicprogramming.unboundedknapsack;

public class CoinChangeMaximumWay {
    public static void main(String[] args) {
        int[] coin = {1, 2};
        int w = 5;
        System.out.println(getMaximumWays(coin, w, coin.length));
    }

    public static int getMaximumWays(int[] coin, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];
        //first row and column not required to initialized because all will by default zero
        for (int i = 0; i < n+1; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (coin[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coin[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][w];
    }
}
