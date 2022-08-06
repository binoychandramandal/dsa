package pepcoding.dynamicprogramming;

public class BuyAndSellStock2 {
    public static void main(String[] args) {
        System.out.println(findMaxProfit(new int[]{1, 2, 3,1,-1,30}));

    }

    /**
     * Multiple transaction allowed.
     * Get the max profit
     * Buy Sell allowed but Buy Buy sell sell not allowed.
     *
     * @param prices
     * @return
     */
    static int findMaxProfit(int[] prices) {
        int buyDate = 0;
        int sellDate = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                sellDate++;
            } else {
                profit += prices[sellDate] - prices[buyDate];
                sellDate = buyDate = i;
            }
        }
        profit += prices[sellDate] - prices[buyDate];
        return profit;
    }
}
