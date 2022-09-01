package dynamicprogramming.longest_common_subSequence;

public class LCSPrint {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        System.out.println(printLcs(x, y, x.length(), y.length()));
    }

    private static String printLcs(String x, String y, int xLength, int yLength) {
        int[][] dp = new int[xLength + 1][yLength + 1];
        LCS.findLCSCountUsingTopDown(x, y, xLength, yLength, dp);
        StringBuilder sb = new StringBuilder();
        int i = xLength;
        int j = yLength;
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                sb.append(x.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        return sb.reverse().toString();
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
