package dynamicprogramming.longest_common_subSequence;

public class LCS {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        System.out.println(findLCSCount(x, y, x.length(), y.length()));
        System.out.println(findLCSCountUsingTopDown(x, y, x.length(), y.length(),new int[x.length() + 1][y.length() + 1]));
        System.out.println(findLCSCountUsingMemoization(x, y, x.length(), y.length(), new Integer[x.length() + 1][y.length() + 1]));

    }

    private static int findLCSCount(String x, String y, int xLength, int yLength) {
        if (xLength == 0 || yLength == 0) {
            return 0;
        }
        if (x.charAt(xLength - 1) == y.charAt(yLength - 1)) {
            return 1 + findLCSCount(x, y, xLength - 1, yLength - 1);
        } else {
            return Math.max(findLCSCount(x, y, xLength - 1, yLength), findLCSCount(x, y, xLength, yLength - 1));
        }
    }

    private static int findLCSCountUsingMemoization(String x, String y, int xLength, int yLength, Integer[][] dp) {
        if (xLength == 0 || yLength == 0) {
            return 0;
        }
        if (dp[xLength][yLength] != null) {
            return dp[xLength][yLength];
        }
        if (x.charAt(xLength - 1) == y.charAt(yLength - 1)) {
            return dp[xLength][yLength] = 1 + findLCSCountUsingMemoization(x, y, xLength - 1, yLength - 1, dp);
        } else {
            return dp[xLength][yLength] = Math.max(findLCSCountUsingMemoization(x, y, xLength - 1, yLength, dp), findLCSCountUsingMemoization(x, y, xLength, yLength - 1, dp));
        }
    }

    public static int findLCSCountUsingTopDown(String x, String y, int xLength, int yLength,int[][] dp ) {
        //initialization not require because first row and column will be 0;
        for (int i = 1; i <= xLength; i++) {
            for (int j = 1; j <= yLength; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // printArray(dp);
        return dp[xLength][yLength];
    }

    static void printArray(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][i] + " ");
            }
            System.out.println();
        }
    }
}
