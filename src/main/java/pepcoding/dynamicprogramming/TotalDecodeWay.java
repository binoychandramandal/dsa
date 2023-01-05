package pepcoding.dynamicprogramming;

public class TotalDecodeWay {
    public static void main(String[] args) {
        System.out.println(decodeString("21123"));
    }

    static int decodeString(String str) {
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            char previousChar = str.charAt(i - 1);
            char currentChar = str.charAt(i);
            if (previousChar == '0' && currentChar == '0') {
                dp[i] = 0;
            } else if (previousChar == '0' && currentChar != '0') {
                dp[i] = dp[i - 1];
            } else if (previousChar != '0' && currentChar == '0') {
                if (previousChar == '1' || previousChar == '2') {
                    dp[i] = (i >= 2) ? dp[i - 2] : 1;
                } else {
                    dp[i] = 0;
                }

            } else {
                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        return dp[str.length() - 1];
    }
}
