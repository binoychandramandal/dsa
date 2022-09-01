package dynamicprogramming.longest_common_subSequence;

public class LargestPalindromicSubSequence {

    public static void main(String[] args) {
        String x = "aba";
        System.out.println(findLongestPalindromicSubSequence(x, x.length()));
    }

    private static int findLongestPalindromicSubSequence(String x, int xLength) {
        String y = new StringBuilder(x).reverse().toString();
        int yLength = y.length();
        int[][] dp = new int[xLength + 1][yLength + 1];
        return LCS.findLCSCountUsingTopDown(x, y, xLength, yLength, dp);
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
