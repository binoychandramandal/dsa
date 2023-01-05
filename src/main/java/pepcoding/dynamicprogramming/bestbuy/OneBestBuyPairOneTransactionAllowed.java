package pepcoding.dynamicprogramming.bestbuy;

public class OneBestBuyPairOneTransactionAllowed {
    public static void main(String[] args) {
        System.out.println(findBestBuyPriceDaysIfOneTransactionAllowed(new int[]{3,2,1}));
    }

    static int findBestBuyPriceDaysIfOneTransactionAllowed(int[] price) {
        int leastPriceSoFar = Integer.MAX_VALUE;

        int profitIfSoldToday = 0;
        int overallProfit = 0;
        for (int i = 0; i < price.length; i++) {
            if (price[i] < leastPriceSoFar) {
                leastPriceSoFar = price[i];
            }

            profitIfSoldToday = price[i]-leastPriceSoFar;
            if(profitIfSoldToday>overallProfit){
                overallProfit=profitIfSoldToday;
            }

        }
        return overallProfit;
    }
}
