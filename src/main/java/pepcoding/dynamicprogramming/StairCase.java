package pepcoding.dynamicprogramming;

public class StairCase {

    public static void main(String[] args) {
        int n = 10;
        //System.out.println(solve(n, new int[n + 1]));

        //System.out.println(countPath(n));
       // System.out.println(getPathCounts(n));
        System.out.println(getPathCounts(n,new int[n+1]));
        System.out.println(countPathWithJump(13, new int[]{5, 5, 2, 4, 1, 5, 9, 8, 6, 3, 8, 9, 1}));
        System.out.println(countPathWithJumpWithMinimumMove(10, new int[]{3, 2, 4, 2, 0, 2, 3, 1, 2, 2}));
    }

    static int getPathCounts(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        System.out.println("calling "+n);
        return getPathCounts(n - 1) + getPathCounts(n - 2) + getPathCounts(n - 3);
    }

    static int getPathCounts(int n,int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if(dp[n]!=0)
            return dp[n];
        System.out.println("calling "+n);
        return dp[n]=getPathCounts(n - 1,dp) + getPathCounts(n - 2,dp) + getPathCounts(n - 3,dp);
    }

    /**
     * Memozation method or top down
     *
     * @param n
     * @param memo
     * @return
     */
    static int solve(int n, int[] memo) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (memo[n] != 0) {
            return memo[n];
        }
        //System.out.println("solve  " + n);
        int path1 = solve(n - 1, memo);
        int path2 = solve(n - 2, memo);
        int path3 = solve(n - 3, memo);
        int totalPath = path1 + path2 + path3;
        memo[n] = totalPath;
        return memo[n];
    }

    /**
     * Using tabulation method
     *
     * @param n
     * @return
     */
    static int countPath(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }

    /**
     * With jump to climb stair case
     *
     * @param n
     * @return
     */
    static int countPathWithJump(int n, int[] jump) {
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= jump[i] && i + j < dp.length; j++) {
                dp[i] += dp[i + j];
            }

        }
        return dp[0];
    }


    /**
     * With jump to climb stair case which takes minimum move
     *
     * @param n
     * @return
     */
    static int countPathWithJumpWithMinimumMove(int n, int[] jump) {
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (jump[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= jump[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null)
                        min = Math.min(min, dp[i + j]);
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                } else {
                    dp[i] = null;
                }
            }
        }
        return dp[0];
    }

}
