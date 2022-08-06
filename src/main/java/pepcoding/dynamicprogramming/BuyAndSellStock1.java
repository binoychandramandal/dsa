package pepcoding.dynamicprogramming;

public class BuyAndSellStock1 {
    public static void main(String[] args) {
        System.out.println(findMaxProfit(new int[]{1, 2, 3}));

    }

    /**
     * Only one transaction allowed.
     * Get the max profit
     *
     * @param prices
     * @return
     */
    static int findMaxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int overAllProfit = 0;
        int profitIfSoldToday = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf) {
                lsf = prices[i];
            }
            profitIfSoldToday = prices[i] - lsf;
            if (profitIfSoldToday > overAllProfit) {
                overAllProfit = profitIfSoldToday;
            }
        }
        return overAllProfit;
    }
}
