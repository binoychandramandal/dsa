package pepcoding.dynamicprogramming;

public class GoldMineMaximumGold {
    public static void main(String[] args) {
        int[][] mine = new int[][]{
                {2,2,2,2,2,2},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1},
                {1,1,1,2,1,1}
        };
        System.out.println(findMaxGold(mine));

    }

    static int findMaxGold(int[][] mine) {
        int[][] dp = new int[mine.length][mine[0].length];
        for (int j = dp[0].length - 1; j >= 0; j--) {
            for (int i = dp.length - 1; i >= 0; i--) {
                if (j == dp[0].length - 1) {
                    dp[i][j] = mine[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + mine[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j + 1]) + mine[i][j];
                } else {
                    dp[i][j] = mine[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]));
                }
            }
        }
        int max=dp[0][0];
        for (int i = 0; i < dp.length; i++) {
            max= Math.max(max,dp[i][0]);
        }
        return max;
    }
}
