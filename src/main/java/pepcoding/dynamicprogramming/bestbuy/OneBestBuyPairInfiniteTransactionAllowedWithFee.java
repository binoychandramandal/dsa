package pepcoding.dynamicprogramming.bestbuy;

public class OneBestBuyPairInfiniteTransactionAllowedWithFee {
    public static void main(String[] args) {
        System.out.println(findBestBuyPriceDaysIfInfiniteTransactionAllowedWithFee(new int[]{10,20,30},2));
    }

    static int findBestBuyPriceDaysIfInfiniteTransactionAllowedWithFee(int[] price,int fee) {
        int obsp = -price[0];
        int ossp = 0;
        for (int i = 1; i < price.length; i++) {
            int nbsp =0;
            int nssp =0;
          //buy profit for today
            if(ossp-price[i]>obsp){
                nbsp = ossp-price[i];
            }else{
                nbsp =obsp;
            }

            //Sell profit for today
            if(obsp+price[i]-fee>ossp){
                nssp = obsp+price[i]-fee;
            }else{
                nssp =ossp;
            }
            obsp=nbsp;
            ossp=nssp;
        }

        return ossp;
    }
}
