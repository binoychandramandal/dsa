package pepcoding.dynamicprogramming;

public class Knapsack01 {
    public static void main(String[] args) {
        System.out.println(zeroOneKnapsack(new int[]{2, 5, 1, 3, 4}, new int[]{15, 14, 10, 45, 30}, 7));
    }


    static int zeroOneKnapsack(int[] wts, int[] vals, int capacity) {
        int[][] dp = new int[wts.length + 1][capacity + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j >= wts[i - 1]) {
                    int rcap = j - wts[i - 1];
                    if (dp[i - 1][rcap] + vals[i - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][rcap] + vals[i - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[wts.length][capacity];
    }
}
