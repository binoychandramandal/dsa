package practise.practice;

public class Test6 {
    public static void main(String[] args) {
        //printCoin(0, new int[]{2, 3, 5, 6, 7}, 0, 12, "");
        printCoin1(0, new int[]{2, 3, 5, 6, 7}, 0, 12, "");
    }

    static void printCoin(int i, int[] coins, int asf, int tam, String ans) {
        if (i >= coins.length) {
            if (asf == tam)
                System.out.println(ans + " = " + tam);
            return;
        }
        printCoin(i + 1, coins, asf + coins[i], tam, ans.isEmpty() ? ans + coins[i] : ans + "+" + coins[i]);
        printCoin(i + 1, coins, asf, tam, ans);
    }

    static void printCoin1(int i, int[] coins, int asf, int tam, String ans) {
        if (i >= coins.length) {
            if (asf == tam)
                System.out.println(ans.substring(1) + " = " + tam);
            return;
        }
        for (int j = tam / coins[i]; j >= 1; j--) {
            String part = "";
            for (int k = 1; k <= j; k++) {
                    part += "+"+coins[i];
            }
            printCoin1(i + 1, coins, asf + coins[i] * j, tam, ans + part);
        }
        printCoin1(i + 1, coins, asf, tam, ans);
    }
}
