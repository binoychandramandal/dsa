package dynamicprogramming.knapsack;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 0 1 Knapsack problem
 */
public class SubSetSumCountWithGivenDifference {

    public static void main(String[] args) {
        int[] wt = {1, 1, 2, 3};
        int diff = 1;
        int sum = Stream.of(wt).collect(Collectors.summingInt(a -> Arrays.stream(a).sum()));
        int s1 = (diff + sum) / 2;
        System.out.println(targetSumUsingTopDown(wt, s1, wt.length));
    }

    /**
     * Same as subset problem
     *
     * @param wt
     * @param w
     * @param n
     * @return
     */
    public static int targetSumUsingTopDown(int[] wt, int w, int n) {
        Integer[][] dp = new Integer[n + 1][w + 1];
        //if no item present then we can make empty subset. if w>1 then we can not make that capacity
        //first row except 0 column we can make false
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - wt[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }


}
