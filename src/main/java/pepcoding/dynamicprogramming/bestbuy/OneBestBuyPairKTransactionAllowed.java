package pepcoding.dynamicprogramming.bestbuy;

public class OneBestBuyPairKTransactionAllowed {
    public static void main(String[] args) {
        //System.out.println(findBestBuyPriceDaysIfTwoTransactionAllowedWithFee(new int[]{10, 20, 30}, 10));
        System.out.println(   optimizedFindBestBuyPriceDaysIfTwoTransactionAllowedWithFee(new int[]{9,6,7,6,3,8},3));
    }

    static int findBestBuyPriceDaysIfTwoTransactionAllowedWithFee(int[] price, int transaction) {
        int[][] dp = new int[transaction + 1][price.length];
        for (int t = 1; t <= transaction; t++) {
            for (int d = 1; d < price.length; d++) {
                int max = dp[t][d - 1];
                for (int pd = 0; pd < d; pd++) {
                    int profitTillTm1 = dp[t - 1][pd];
                    int ptth = price[d] - price[pd];
                    if (profitTillTm1 + ptth > max) {
                        max = profitTillTm1 + ptth;
                    }
                }
                dp[t][d] = max;
            }
        }
        return dp[transaction][price.length - 1];
    }

    static int optimizedFindBestBuyPriceDaysIfTwoTransactionAllowedWithFee(int[] price, int transaction) {
        int[][] dp = new int[transaction + 1][price.length];

        for (int t = 1; t <= transaction; t++) {
            int max = Integer.MIN_VALUE;
            for (int d = 1; d < price.length; d++) {
                if (dp[t - 1][d - 1] - price[d - 1] > max) {
                  max = dp[t - 1][d - 1] - price[d - 1];
                }

                if(max+price[d]>dp[t][d-1]){
                    dp[t][d] =max+price[d];
                }else{
                    dp[t][d] = dp[t][d-1];
                }

            }
        }
        return dp[transaction][price.length - 1];
    }
}
