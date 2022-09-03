package sorting.classwise;

import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] a = {1, 5, 9};
        int[] b = {2, 3, 4, 6};
        int[] m = merge(a, b);
        System.out.println(Arrays.toString(m));
        int part[] = {1, 5, 9, 2, 3, 4, 6};
        int[] result = mergePart(part, 0, 2, 6);
        System.out.println(Arrays.toString(part));
        System.out.println(Arrays.toString(result));
    }

    /**
     * Merge two sorted array
     *
     * @param a array 1
     * @param b array 2
     * @return merged sorted array
     */
    private static int[] merge(int[] a, int[] b) {
        if (a == null || a.length <= 0)
            return b;
        if (b == null || b.length <= 0) {
            return a;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[a.length + b.length];
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        while (i < a.length) {
            result[k++] = a[i++];
        }
        while (j < b.length) {
            result[k++] = a[j++];
        }
        return result;
    }


    static int[] mergePart(int[] a, int s, int m, int end) {
        if (a == null || s < 0 || end > a.length) {
            return a;
        }
        int[] result = new int[end - s + 1];
        int i = 0;
        int j = m + 1;
        int k = 0;
        while (i <= m && j <= end) {
            if (a[i] < a[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = a[j++];
            }
        }
        while (i <= m) {
            result[k++] = a[i++];
        }
        while (j <= end) {
            result[k++] = a[j++];
        }
        return result;
    }


}
