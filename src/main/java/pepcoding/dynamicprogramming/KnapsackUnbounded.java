package pepcoding.dynamicprogramming;

public class KnapsackUnbounded {
    public static void main(String[] args) {
        System.out.println(unboundKnapsack(new int[]{2, 5, 1, 3, 4}, new int[]{15, 14, 10, 45, 30}, 7));
    }


    static int unboundKnapsack(int[] wts, int[] vals, int capacity) {
        int[] dp = new int[capacity + 1];
        dp[0] = 0;
        for (int bagc = 1; bagc <= capacity; bagc++) {
            int max = 0;
            for (int i = 0; i < wts.length; i++) {
                if (wts[i] <= bagc) {
                    int rbac = bagc - wts[i];
                    int rbagv = dp[rbac];
                    int tbagv = rbagv + vals[i];
                    if (tbagv > max) {
                        max = tbagv;
                    }
                }
            }
            dp[bagc] = max;
        }
        return dp[capacity];
    }
}
