package recurrsion.practise;

public class CoinChangeProblem {
    public static void main(String[] args) {
        coinChange(0, new int[]{2, 3, 5}, 0, 7, "");
        coinChangeWithAnytimes(0,new int[]{2,3,4,5},0,12,"");
    }

    /**
     * one coin can be used at most once
     *
     * @param i
     * @param coins
     * @param amtsf
     * @param tamt
     * @param asf
     */
    static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        if (i == coins.length) {
            if (amtsf == tamt) {
                System.out.println(asf + ".");
            }
            return;
        }
        coinChange(i + 1, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
        coinChange(i + 1, coins, amtsf, tamt, asf);
    }

    /**
     * one coin can be used any number times
     *
     * @param i
     * @param coins
     * @param amtsf
     * @param tamt
     * @param asf
     */
    static void coinChangeWithAnytimes(int i, int[] coins, int amtsf, int tamt, String asf) {
        if (i == coins.length) {
            if (amtsf == tamt) {
                System.out.println(asf + ".");
            }
            return;
        }
        for (int j = tamt / coins[i]; j >= 1; j--) {
            String part = "";
            for (int k = 0; k < j; k++) {
                part += coins[i] + "-";
            }
            coinChangeWithAnytimes(i + 1, coins, amtsf + coins[i]*j, tamt, asf +part);
        }

        coinChangeWithAnytimes(i + 1, coins, amtsf, tamt, asf);
    }
}
