package dynamicprogramming.unboundedknapsack;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] wt = {3, 4, 6, 5};
        int[] val = {2, 3, 1, 4};
        int w = 8;
        System.out.println("Recursion-> " + maxProfit(wt, val, w, wt.length));
    }
    public static int maxProfit(int[] wt, int[] val, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (wt[n - 1] <= w) {
            return Math.max(val[n - 1] + maxProfit(wt, val, w - wt[n - 1], n ), maxProfit(wt, val, w, n - 1));
        } else {
            return maxProfit(wt, val, w, n - 1);
        }
    }
}
