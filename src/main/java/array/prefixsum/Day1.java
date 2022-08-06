package array.prefixsum;

import java.util.Arrays;

public class Day1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generatePrefixSumArray(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(generatePrefixSumArrayFromRight(new int[]{1, 2, 3})));
        System.out.println(findEquilibriumIndex(new int[]{-7, 1, 5, 2, -4, 3, 0}));
        System.out.println(findEquilibriumIndex1(new int[]{-7, 1, 5, 2, -4, 3, 0}));

        System.out.println(solve(new int[]{814, 761, 697, 483, 981}));

    }

    public static int solve(int[] A) {
        if (A.length == 1) {
            return 1;
        }
        if (A.length == 2) {
            return 2;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        int counterMin = -1;
        int counterMax = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == min) {
                counterMin = i;
            }
            if (A[i] == max) {
                counterMax = i;
            }
            if (counterMin != -1 && counterMax != -1) {
                ans = Math.min(ans, Math.abs(counterMax - counterMin) + 1);
            }
        }
        return ans;
    }

    /**
     * Find equlibrium index  count
     *
     * @param a
     * @return
     */
    public static int findEquilibriumIndex(int[] a) {
        int[] pfl = generatePrefixSumArray(a);
        int[] pfr = generatePrefixSumArrayFromRight(a);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (pfl[i] == pfr[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * Find equlibrium index  count
     *
     * @param a
     * @return
     */
    public static int findEquilibriumIndex1(int[] a) {
        int[] pfl = generatePrefixSumArray(a);
        int count = 0;
        if (pfl[a.length - 1] - pfl[0] == 0) {
            count++;
        }
        for (int i = 1; i < a.length; i++) {
            int left = pfl[i - 1];
            int right = pfl[a.length - 1] - a[i];

            if (left == right) {
                count++;
            }
        }
        return count;
    }


    /**
     * Generate prefix sum array from right side
     *
     * @param a
     * @return
     */
    public static int[] generatePrefixSumArrayFromRight(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int[] pf = new int[a.length];
        pf[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            pf[i] = pf[i + 1] + a[i];
        }
        return pf;
    }

    /**
     * Generate prefix sum array
     *
     * @param a
     * @return
     */
    public static int[] generatePrefixSumArray(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int[] pf = new int[a.length];
        pf[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            pf[i] = pf[i - 1] + a[i];
        }
        return pf;
    }

}
