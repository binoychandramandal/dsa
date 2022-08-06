package pepcoding.dynamicprogramming;

public class BuyAndSellStock4 {
    public static void main(String[] args) {
        System.out.println(findMaxProfit(new int[]{10, 20, 30}));

    }

    /**
     * Multiple transaction allowed but cool down period.
     * Get the max profit
     * Buy Sell allowed but Buy Buy sell sell not allowed.
     *
     * @param prices
     * @return
     */
    static int findMaxProfit(int[] prices) {
        int OldBuyStateProfit = -prices[0];
        int OldSellStateProfit = 0;
        int OldCoolDownStateProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int newBuyStateProfit = 0;
            int newSellStateProfit = 0;
            int newCoolDownStateProfit = 0;
            if (OldCoolDownStateProfit - prices[i] > OldBuyStateProfit) {// buying side
                newBuyStateProfit = OldCoolDownStateProfit - prices[i];
            } else {
                newBuyStateProfit = OldBuyStateProfit;
            }

            if (OldBuyStateProfit + prices[i] > OldSellStateProfit) {
                newSellStateProfit = OldBuyStateProfit + prices[i];
            } else {
                newSellStateProfit = OldSellStateProfit;
            }
            if(OldSellStateProfit>OldCoolDownStateProfit){
                newCoolDownStateProfit = OldSellStateProfit;
            }else{
                newCoolDownStateProfit = OldCoolDownStateProfit;
            }
            OldBuyStateProfit = newBuyStateProfit;
            OldSellStateProfit = newSellStateProfit;
            OldCoolDownStateProfit =newCoolDownStateProfit;
        }
        return OldSellStateProfit;
    }
}
