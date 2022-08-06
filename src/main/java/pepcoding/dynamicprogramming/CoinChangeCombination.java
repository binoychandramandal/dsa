package pepcoding.dynamicprogramming;

public class CoinChangeCombination {
    public static void main(String[] args) {
        System.out.println(countWayToCoinChangeCombination(new int[]{2, 3, 5}, 7));
    }

    /**
     * Count the number of way we can give target amount.
     * if coin[2,3,5] and target is 7 then 2 way we can give 7.
     * Example: 2+2+3 and 2+5
     * Coin will be infinite of any coin. like 2 coin can be used as many time it required.
     *
     * @param coin
     * @param target
     * @return
     */
    static int countWayToCoinChangeCombination(int[] coin, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j < dp.length; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }
        return dp[target];
    }
}
