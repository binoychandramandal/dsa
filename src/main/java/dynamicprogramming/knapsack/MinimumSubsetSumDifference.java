package dynamicprogramming.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 0 1 Knapsack problem
 */
public class MinimumSubsetSumDifference {

    public static void main(String[] args) {
        int[] wt = {4, 6, 5, 12};
        System.out.println(minimumSubsetSumDifference(wt));
    }

    public static  int minimumSubsetSumDifference(int[] wt){
        int sum = Stream.of(wt).collect(Collectors.summingInt(a-> Arrays.stream(a).sum()));
        boolean[][] dp =new boolean[wt.length+1][sum+1];
        subsetSum(wt,sum,wt.length,dp);
        boolean[] lastRow = dp[wt.length];
        List<Integer> s1Value = new ArrayList<>();
        for (int i = 0; i < lastRow.length; i++) {
            if(lastRow[i]){
                s1Value.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s1Value.size()/2; i++) {
            min = Math.min(min,(sum-2*s1Value.get(i)));
        }
        return min;
    }

    /**
     * Same as subset problem
     *
     * @param wt
     * @param w
     * @param n
     * @return
     */
    public static boolean subsetSum(int[] wt, int w, int n, boolean[][] dp) {
        //if no item present then we can make empty subset. if w>1 then we can not make that capacity
        //first row except 0 column we can make false
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - wt[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }


}
