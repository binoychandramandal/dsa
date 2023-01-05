package pepcoding.dynamicprogramming.bestbuy;

public class OneBestBuyPairTwoTransactionAllowed {
    public static void main(String[] args) {
        System.out.println(findBestBuyPriceDaysIfTwoTransactionAllowedWithFee(new int[]{10, 20, 30}));
    }

    static int findBestBuyPriceDaysIfTwoTransactionAllowedWithFee(int[] price) {
        int leastPriceTillNow = price[0];
        int maximumProfitIfSoldToday = 0;
        int[] dpl = new int[price.length];
        for (int i = 1; i < price.length; i++) {
            if (price[i] < leastPriceTillNow) {
                leastPriceTillNow = price[i];
            }
            maximumProfitIfSoldToday = price[i] - leastPriceTillNow;
            if (maximumProfitIfSoldToday > dpl[i - 1]) {
                dpl[i] = maximumProfitIfSoldToday;
            } else {
                dpl[i] = dpl[i - 1];
            }

        }

        int[] dpr = new int[price.length];
        int maxAfterToday = price[price.length - 1];
        int maxProfitIfBuyToday = 0;
        for (int i = price.length - 2; i >= 0; i--) {
            if (price[i] > maxAfterToday) {
                maxAfterToday = price[i];
            }

            maxProfitIfBuyToday = maxAfterToday - price[i];
            if (maxProfitIfBuyToday > dpr[i + 1]) {
                dpr[i] = maxProfitIfBuyToday;
            } else {
                dpr[i] = dpr[i + 1];
            }
        }

        int op = 0;
        for (int i = 0; i < dpl.length; i++) {
            int p = dpl[i] + dpr[i];
            if (p > op) {
                op = p;
            }
        }
        return op;
    }
}
