package dynamicprogramming.knapsack;

/**
 * 0 1 Knapsack problem
 */
public class SubSetSum {

    public static void main(String[] args) {
        int[] wt = {3, 34, 4, 12, 10, 2};
        int w = 9;
        System.out.println(targetSum(wt, w, wt.length));
        System.out.println(targetSum(wt, w, wt.length, new Boolean[wt.length + 1][w + 1]));
        System.out.println(targetSumUsingTopDown(wt, w, wt.length));
    }

    /**
     * Using recursion
     *
     * @param wt
     * @param w
     * @param n
     * @return
     */
    public static boolean targetSum(int[] wt, int w, int n) {
        if (w == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (wt[n - 1] <= w) {
            return targetSum(wt, w - wt[n - 1], n - 1) || targetSum(wt, w, n - 1);
        } else {
            return targetSum(wt, w, n - 1);
        }
    }

    /**
     * Using memozation
     *
     * @param wt
     * @param w
     * @param n
     * @param dp
     * @return
     */
    public static boolean targetSum(int[] wt, int w, int n, Boolean[][] dp) {
        if (w == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (dp[n][w] != null) {
            return dp[n][w];
        }
        if (wt[n - 1] <= w) {
            return dp[n][w] = targetSum(wt, w - wt[n - 1], n - 1, dp) || targetSum(wt, w, n - 1, dp);
        } else {
            return dp[n][w] = targetSum(wt, w, n - 1, dp);
        }
    }

    /**
     * Using top down
     *
     * @param wt
     * @param w
     * @param n
     * @return
     */
    public static boolean targetSumUsingTopDown(int[] wt, int w, int n) {
        Boolean[][] dp = new Boolean[n + 1][w + 1];
        //if no item present then we can make empty subset. if w>1 then we can not make that capacity
        //first row except 0 column we can make false
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - wt[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }


}
