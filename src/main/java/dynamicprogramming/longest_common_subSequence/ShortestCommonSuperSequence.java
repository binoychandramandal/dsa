package dynamicprogramming.longest_common_subSequence;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String x = "geek";
        String y = "eke";
        System.out.println(printSuperSequenceLength(x, y, x.length(), y.length()));
    }

    private static int printSuperSequenceLength(String x, String y, int xLength, int yLength) {
        int[][] dp = new int[xLength + 1][yLength + 1];
        LCS.findLCSCountUsingTopDown(x, y, xLength, yLength, dp);
        return x.length()+y.length()-dp[xLength][yLength];
    }
}
