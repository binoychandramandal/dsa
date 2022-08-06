package pepcoding.dynamicprogramming;

public class CoinChangePermutation {
    public static void main(String[] args) {
        System.out.println(countWayToCoinChangePermutation(new int[]{2,3,5,6},10));
    }


    static int countWayToCoinChangePermutation(int[] coin, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coin.length; j++) {
                if(coin[j]<=i){
                    dp[i] += dp[i - coin[j]];
                }

            }
        }
        return dp[target];
    }
}
