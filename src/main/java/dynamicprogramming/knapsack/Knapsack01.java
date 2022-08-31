package dynamicprogramming.knapsack;

/**
 * 0 1 Knapsack problem
 */
public class Knapsack01 {

    public static void main(String[] args) {
        int[] wt = {3, 4, 6, 5};
        int[] val = {2, 3, 1, 4};
        int w = 8;
        System.out.println("Recursion-> " + maxProfit(wt, val, w, wt.length));

        System.out.println("Memozation-> " + maxProfit(wt, val, w, wt.length, new Integer[wt.length + 1][w + 1]));
        System.out.println("Top down->  " + maxProfitUsingTopDown(wt, val, w, wt.length));
    }

    /**
     * Using recursion
     *
     * @param wt
     * @param val
     * @param w
     * @param n
     * @return
     */
    public static int maxProfit(int[] wt, int[] val, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (wt[n - 1] <= w) {
            return Math.max(val[n - 1] + maxProfit(wt, val, w - wt[n - 1], n - 1), maxProfit(wt, val, w, n - 1));
        } else {
            return maxProfit(wt, val, w, n - 1);
        }
    }

    /**
     * Using memozation
     *
     * @param wt
     * @param val
     * @param w
     * @param n
     * @param dp
     * @return
     */
    public static int maxProfit(int[] wt, int[] val, int w, int n, Integer[][] dp) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (dp[n][w] != null) {
            return dp[n][w];
        }
        if (wt[n - 1] <= w) {
            return dp[n][w] = Math.max(val[n - 1] + maxProfit(wt, val, w - wt[n - 1], n - 1, dp), maxProfit(wt, val, w, n - 1, dp));
        } else {
            return dp[n][w] = maxProfit(wt, val, w, n - 1, dp);
        }
    }

    /**
     * Using top down
     *
     * @param wt
     * @param val
     * @param w
     * @param n
     * @return
     */
    public static int maxProfitUsingTopDown(int[] wt, int[] val, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }


}
