package pepcoding.backtracking;

public class Permutation1 {
    public static void main(String[] args) {
        printPermutation(1, 3, new int[3], 0, 3, "");
    }

    static void printPermutation(int cb, int tb, int[] items, int ssf, int ts, String asf) {
        if (cb > tb) {
            if (ssf == ts)
                System.out.println(asf);
            return;
        }

        for (int i = 0; i < ts; i++) {
            if (items[i] == 0) {
                items[i] = 1;
                printPermutation(cb + 1, tb, items, ssf + 1, ts, asf + (i + 1));
                items[i] = 0;
            }
        }
        printPermutation(cb + 1, tb, items, ssf, ts, asf + "0");
    }
}
