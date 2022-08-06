package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 {
    public static void main(String[] args) {
        System.out.println(getCount(new int[]{-3, 2, 5, 6, 7, 8}));
        System.out.println(existsPair(new int[]{3, -2, 1, 4, 3, 6, 8}, 10));
        System.out.println(existsPairCount(new int[]{3, 2, 1, 4, 3, 6, 8}, 10));
        System.out.println(existsPairCountWithIndex(new int[]{3, 2, 1, 4, 3, 6, 8}, 10));
    }

    /**
     * Find count number of element having at lest 1 element greater than itself
     *
     * @param a array
     * @return count of such element which is having count 1 larger
     */
    public static int getCount(int[] a) {
        //find max element
        if (a == null || a.length == 0) {
            return 0;
        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }

        //count occurance of max in the array
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                count++;
            }
        }
        return a.length - count;
    }

    /**
     * Check if there exists a pair (i,j) such that a[i]+a[j]==k & i!=j
     *
     * @param a input array
     * @param k key of a pair
     * @return true if present else false
     */
    public static boolean existsPair(int[] a, int k) {
        if (a == null || a.length == 0) {
            return false;
        }
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * count if there exists a pair (i,j) such that a[i]+a[j]==k & i!=j
     *
     * @param a input array
     * @param k key of a pair
     * @return count if present
     */
    public static int existsPairCount(int[] a, int k) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * find index if there exists a pair (i,j) such that a[i]+a[j]==k & i!=j
     *
     * @param a input array
     * @param k key of a pair
     * @return count if present
     */
    public static List<List<Integer>> existsPairCountWithIndex(int[] a, int k) {
        if (a == null || a.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == k) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
}
