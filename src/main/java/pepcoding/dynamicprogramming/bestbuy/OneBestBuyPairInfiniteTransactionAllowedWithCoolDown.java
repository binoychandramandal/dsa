package pepcoding.dynamicprogramming.bestbuy;

public class OneBestBuyPairInfiniteTransactionAllowedWithCoolDown {
    public static void main(String[] args) {
        System.out.println(findBestBuyPriceDaysIfInfiniteTransactionAllowedWithFee(new int[]{10,20,30},2));
    }

    static int findBestBuyPriceDaysIfInfiniteTransactionAllowedWithFee(int[] price,int fee) {
        int obsp = -price[0];
        int ossp = 0;
        int ocsp=0;
        for (int i = 1; i < price.length; i++) {
            int nbsp =0;
            int nssp =0;
            int ncsp =0;
          //buy profit for today
            if(ocsp-price[i]>obsp){
                nbsp = ocsp-price[i];
            }else{
                nbsp =obsp;
            }

            //Sell profit for today
            if(ocsp+price[i]>ossp){
                nssp = obsp+price[i];
            }else{
                nssp =ossp;
            }
            if(ossp>ocsp){
                ncsp =ossp;
            }else{
                ncsp = ocsp;
            }
            obsp=nbsp;
            ossp=nssp;
            ocsp =ncsp;
        }

        return ossp;
    }
}
