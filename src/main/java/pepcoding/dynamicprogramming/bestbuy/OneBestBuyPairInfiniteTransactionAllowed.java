package pepcoding.dynamicprogramming.bestbuy;

public class OneBestBuyPairInfiniteTransactionAllowed {
    public static void main(String[] args) {
        System.out.println(findBestBuyPriceDaysIfInfiniteTransactionAllowed(new int[]{1,5,4,10,9}));
    }

    static int findBestBuyPriceDaysIfInfiniteTransactionAllowed(int[] price) {
        int buyDate =0;
        int sellDate = 0;
        int profit = 0;
        for (int i = 1; i < price.length; i++) {
           if(price[i]>price[i-1]){
               sellDate++;
           }else{
               profit+=price[sellDate]-price[buyDate];
           }
        }
        profit+=price[sellDate]-price[buyDate];
        return profit;
    }
}
