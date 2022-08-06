package array.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Day2 {
    public static void main(String[] args) {

        System.out.println(isExists());
        System.out.println(Arrays.toString(evenIndexSum(new int[]{1, 1, 1})));
        System.out.println(Arrays.toString(oddIndexSum(new int[]{1, 1, 1})));
        int[] evenSum = evenIndexSum(new int[]{1, 1, 1});
        int[] oddSum = oddIndexSum(new int[]{1, 1, 1});
        System.out.println(calculateSumFromPrefixSumArray(evenSum, 0, 0));
        System.out.println(calculateSumFromPrefixSumArray(oddSum, 0, 0));
        System.out.println(countSpecialIndex(new int[]{1,1,1}));
        System.out.println(countSpecialIndex(new int[]{2, 1, 6, 4 }));
        System.out.println(countSpecialIndex(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    }

    public static int isExists(){

        int[] a=new int[]{5, 4, 10, 15, 7, 6};
        int b=5;
        HashSet<Integer> s=new HashSet<>();
        int count=0;
        for (int i : a) {
            if(s.contains(i^b)){
                count++;
            }
            s.add(i);
        }
        return count;
    }

    /**
     * Find special index count.
     * ith index is called special index if after removing that index evenSum==oddSum then ith index is a special index
     *
     * @param a input array
     * @return count of special index
     */
    public static int countSpecialIndex(int[] a) {
        int[] evenSum = evenIndexSum(a);
        int[] oddSum = oddIndexSum(a);
        int count = 0;
        if (calculateSumFromPrefixSumArray(evenSum,1,a.length-1) == calculateSumFromPrefixSumArray(oddSum,1,a.length - 1)) {
            count++;
        }
        if (calculateSumFromPrefixSumArray(evenSum,0,a.length - 2) == calculateSumFromPrefixSumArray(oddSum,0,a.length - 2)) {
            count++;
        }
        for (int i = 1; i < a.length - 1; i++) {
            int evenFirstPartSum = calculateSumFromPrefixSumArray(evenSum, 0, i - 1);
            int oddFirstPartSum = calculateSumFromPrefixSumArray(oddSum, 0, i - 1);

            int evenSecondPartSum = calculateSumFromPrefixSumArray(oddSum, i + 1, a.length - 1);
            int oddSecondPartSum = calculateSumFromPrefixSumArray(evenSum, i + 1, a.length - 1);

            if (evenFirstPartSum + evenSecondPartSum == oddFirstPartSum + oddSecondPartSum) {
                count++;
            }

        }
        return count;
    }

    /**
     * Calculate sum from prefix sum array
     *
     * @param oddSum
     * @param l      left index of array
     * @param right  right index of array
     * @return sum
     */
    public static int calculateSumFromPrefixSumArray(int[] oddSum, int l, int right) {
        if (l == 0) {
            return oddSum[right];
        } else {
            return oddSum[right] - oddSum[l - 1];
        }
    }


    /**
     * Even index prefix sum created
     *
     * @param a input array
     * @return same length array which contains even index sum
     */
    public static int[] evenIndexSum(int[] a) {
        if (a.length == 1) {
            return a;
        }
        int evenSum[] = new int[a.length];
        evenSum[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            if (i % 2 == 0) {
                evenSum[i] = evenSum[i - 1] + a[i];
            } else {
                evenSum[i] = evenSum[i - 1];
            }
        }
        return evenSum;
    }

    /**
     * Odd index prefix sum created
     *
     * @param a input array
     * @return same length array which contains Odd index sum
     */
    public static int[] oddIndexSum(int[] a) {
        int oddSum[] = new int[a.length];
        if (a == null || a.length == 0) {
            return oddSum;
        }
        oddSum[0] = 0;
        for (int i = 1; i < a.length; i++) {
            if (i % 2 == 1) {
                oddSum[i] = oddSum[i - 1] + a[i];
            } else {
                oddSum[i] = oddSum[i - 1];
            }
        }
        return oddSum;
    }


}
