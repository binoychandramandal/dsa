package dynamicprogramming.longest_common_subSequence;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String x = "abcdef";
        String y = "ab";
        System.out.println(findLCSCountUsingTopDown(x, y, x.length(), y.length()));
    }

    /**
     * Same as LCS only chnage when two char not match just store 0
     * @param x
     * @param y
     * @param xLength
     * @param yLength
     * @return
     */
    private static int findLCSCountUsingTopDown(String x, String y, int xLength, int yLength) {
        int[][] dp = new int[xLength + 1][yLength + 1];
        int result =Integer.MIN_VALUE;
        //initialization not require because first row and column will be 0;
        for (int i = 1; i <= xLength; i++) {
            for (int j = 1; j <= yLength; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] =1 + dp[i - 1][j - 1];
                    result =  Math.max(result,dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
         printArray(dp);
        return result;
    }

    static void printArray(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
