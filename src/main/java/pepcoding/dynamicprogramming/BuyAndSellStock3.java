package pepcoding.dynamicprogramming;

public class BuyAndSellStock3 {
    public static void main(String[] args) {
        System.out.println(findMaxProfit(new int[]{10,20,30}, 2));

    }

    /**
     * Multiple transaction allowed but fee on sell.
     * Get the max profit
     * Buy Sell allowed but Buy Buy sell sell not allowed.
     *
     * @param prices
     * @return
     */
    static int findMaxProfit(int[] prices, int fee) {
        int OldBuyStateProfit = -prices[0];
        int OldSellStateProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int newBuyStateProfit = 0;
            int newSellStateProfit = 0;
            if (OldSellStateProfit - prices[i] > OldBuyStateProfit) {// buying side
                newBuyStateProfit = OldSellStateProfit - prices[i];
            } else {
                newBuyStateProfit = OldBuyStateProfit;
            }

            if (OldBuyStateProfit + prices[i] - fee > OldSellStateProfit) {
                newSellStateProfit = OldBuyStateProfit + prices[i] - fee;
            } else {
                newSellStateProfit = OldSellStateProfit;
            }
            OldBuyStateProfit = newBuyStateProfit;
            OldSellStateProfit = newSellStateProfit;
        }
        return OldSellStateProfit;
    }
}
