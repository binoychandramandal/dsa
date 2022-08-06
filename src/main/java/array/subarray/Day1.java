package array.subarray;

import java.util.Arrays;

public class Day1 {
    public static void main(String[] args) {
        printSubArray(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(rotateSubArray(new int[]{1, 2, 3}, 0, 1)));
        System.out.println(Arrays.toString(rotateSubArray(new int[]{1, 2, 3, 4}, 2)));
        System.out.println(Arrays.toString(rotateSubArrayLeftToRight(new int[]{1, 2, 3, 4,5,6}, 3)));
        printSubArrayIndex(new int[]{1, 2, 3, 4,5,6},2);
    }

    /**
     * Print start and end index of all sub arrays with length k
     *
     * @param a
     */
    public static void printSubArrayIndex(int[] a, int k) {
        System.out.println("Sub array index");
        for (int i = 0; i <=a.length-k; i++) {
            int j=i+k-1;
            System.out.println(i+" -> "+j);
        }
    }

    /**
     * Rotate  array right to left
     *
     * @param a
     */
    public static int[] rotateSubArray(int[] a, int k) {
        k = k % a.length;
        rotateSubArray(a, 0, a.length - 1);
        rotateSubArray(a, 0, k - 1);
        rotateSubArray(a, k, a.length - 1);
        return a;
    }

    /**
     * Rotate  array left to right
     *
     * @param a
     */
    public static int[] rotateSubArrayLeftToRight(int[] a, int k) {
        k = k % a.length;
        rotateSubArray(a, 0, a.length - 1);
        rotateSubArray(a, 0, a.length-k - 1);
        rotateSubArray(a, a.length-k, a.length - 1);
        return a;
    }

    /**
     * Rotate sub array
     *
     * @param a
     */
    public static int[] rotateSubArray(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
        return a;
    }

    /**
     * print all sub array
     *
     * @param a
     */
    public static void printSubArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = i; k <= j; k++) {
                    sb.append(a[k]);
                    if (k < j) {
                        sb.append(",");
                    }
                }
                System.out.println(sb.toString());
            }
        }

    }
}
