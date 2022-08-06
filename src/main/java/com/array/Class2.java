package com.array;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Class2 {
    public static void main(String[] args) {
        long m=(long)Integer.MAX_VALUE+1;
        long l=m;
        System.out.println(m);
        printAllSubArray(new int[]{1, 2, 3, 4, 5});
        printAllSubArraySums(new int[]{1, 2, 3, 4, 5});
        printAllSubArraySumsContributionTechnique(new int[]{1, 2, 3, 4, 5});
        printAllSubArrayOfLength(new int[]{1, 2, 3, 4, 5, 6}, 3);
        printMaxSumSubArrayOfLength(new int[]{-3, 4, -2, 5, 3, -2, 8, 2, -1, 4}, 5);
        printMaxSumSubArrayOfLengthSlidingWindow(new int[]{-3, 4, -2, 5, 3, -2, 8, 2, -1, 4}, 5);
        //solve(new int[]{3, 7, 90, 20, 10, 50, 40},3);
        //solve(new int[]{3, 7, 5, 20, -10, 0, 12},2);
        solve(new int[]{20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11}, 9);
        int count = euilibriumIndex(new int[]{3, -1, 2, -1, 1, 2, 1});
        System.out.println(count);
    }
    public String largestNumber(final Integer[] A) {
        Arrays.sort(A, Collections.reverseOrder());
        return Arrays.toString(A);
    }

    public static int euilibriumIndex(final int[] A) {
        Arrays.sort(new int[]{});
        int[] pf = new int[A.length];
        pf[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pf[i] = pf[i - 1] + A[i];
        }
        int count = 0;
        if (pf[A.length - 1] - pf[0] == 0) {
            count++;
        }
        for (int i = 1; i < A.length; i++) {
            int left = pf[i - 1];
            int right = pf[A.length - 1] - pf[i];

            if (left == right) {
                count++;
            }
        }
        return count;
    }


    public static int maxSubArray(final int[] A) {
        int[] pf = new int[A.length];
        pf[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pf[i] = pf[i - 1] + A[i];
        }
        System.out.println(Arrays.toString(pf));
        int max = pf[0];
        for (int i = 1; i < pf.length; i++) {
            max = Math.max(max, pf[i]);
        }
        System.out.println(max);
        return max;
    }

    public static int solve(int[] A, int B) {
        double sum = 0;
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }
        double min = sum / B;
        int index = 0;
        for (int i = 1; i <= A.length - B; i++) {
            sum = sum - A[i - 1] + A[i + B - 1];
            double avg = sum / B;
            if (min > avg) {
                min = avg;
                index = i;
            }
        }
        System.out.println(index);
        return index;
    }

    /**
     * print all sub array
     * n(n+1)/2 total sub array count
     *
     * @param a array
     * @return count of such element
     */
    public static void printAllSubArray(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j < a.length; j++) {
                System.out.print("{");
                for (int k = i; k <= j; k++) {
                    if (k < j)
                        System.out.print(a[k] + ",");
                    else
                        System.out.print(a[k] + "");
                }
                System.out.print("} ");
            }
            System.out.println();
        }
    }

    /**
     * print all sub array sum
     * n(n+1)/2 total sub array count
     *
     * @param a array
     * @return count of such element
     */
    public static void printAllSubArraySums(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }

    /**
     * print all sub array sum using contribution technique
     * n(n+1)/2 total sub array count
     *
     * @param a array
     * @return count of such element
     */
    public static void printAllSubArraySumsContributionTechnique(int[] a) {
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            int left = i + 1;
            int right = a.length - i;
            sum = a[i] * left * right;
        }
        System.out.println("Total Sum: " + sum);
    }

    /**
     * print start and end index of subarray which having length k
     *
     * @param a array
     * @return count of such element
     */
    public static void printAllSubArrayOfLength(int[] a, int k) {
        for (int startIndex = 0; startIndex <= a.length - k; startIndex++) {
            int endIndex = startIndex + k - 1;
            System.out.print("{" + startIndex + "," + endIndex + "} ");
        }
        System.out.println();
    }

    /**
     * print max sum sub array which having length k
     *
     * @param a array
     * @return count of such element
     */
    public static int printMaxSumSubArrayOfLength(int[] a, int k) {
        int max = Integer.MIN_VALUE;
        for (int startIndex = 0; startIndex <= a.length - k; startIndex++) {
            int endIndex = startIndex + k - 1;
            int sum = 0;
            for (int i = startIndex; i <= endIndex; i++) {
                sum += a[i];
            }
            if (max < sum) max = sum;
        }
        System.out.println(max);
        return max;
    }

    /**
     * print max sum sub array which having length k
     *
     * @param a array
     * @return count of such element
     */
    public static int printMaxSumSubArrayOfLengthSlidingWindow(int[] a, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        int max = Integer.MIN_VALUE;
        for (int startIndex = 1; startIndex <= a.length - k; startIndex++) {
            int endIndex = startIndex + k - 1;
            sum = sum - a[startIndex - 1] + a[endIndex];
            if (max < sum) max = sum;
        }
        System.out.println(max);
        return max;
    }


}
