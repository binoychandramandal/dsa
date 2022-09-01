package dynamicprogramming.unboundedknapsack;

public class RodCutting {
    public static void main(String[] args) {
        int[] wt = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] val = {1, 5, 8, 9, 10, 17, 17, 20};
        int w = 4;
        System.out.println("Recursion-> " + maxProfit(wt, val, w, wt.length));

        int[] wt1 = {1, 3, 5};
        int[] val1 = {1, 5, 8};
        int w1 = 3;
        System.out.println("Recursion-> " + maxProfit(wt1, val1, w1, wt1.length));
    }

    public static int maxProfit(int[] wt, int[] val, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];
        //first row and column will be zero
        //by default it will zero only
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printArray(dp);
        return dp[n][w];
    }
    static void printArray(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
