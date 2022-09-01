package dynamicprogramming.unboundedknapsack;

public class CoinChangeMinimumNumberOfCoin {
    public static void main(String[] args) {
        int[] coin = {};
        int w = 5;
        System.out.println(getMinimumNumberOfCoin(coin, w, coin.length));
    }

    public static int getMinimumNumberOfCoin(int[] coin, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];
        //first row and column not required to initialized because all will by default zero
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= w; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        if (n > 1)
            for (int j = 1; j <= w; j++) {
                if (j % coin[0] == 0) {
                    dp[1][j] = j / coin[0];
                } else {
                    dp[1][j] = Integer.MAX_VALUE - 1;
                }
            }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (coin[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i][j - coin[i - 1]] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][w];
    }
}
