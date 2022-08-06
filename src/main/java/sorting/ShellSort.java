package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShellSort {
    public static void main(String[] args) {

//        System.out.println(digit(10));
//        System.out.println(digit(1));
//        System.out.println(pow(10, 9));


        // System.out.println(digit(10, 1));
        int[] a = new int[]{4, 3, 2, 1, 1000000000, Integer.MAX_VALUE};
        shellShort(a);
        System.out.println(Arrays.toString(a));

    }

    static void shellShort(int[] a) {
        //get max elememt
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }

        //get max elements digit count
        int d = digitCount(max);
        for (int i = 0; i < d; i++) {
            ArrayList[] l = new ArrayList[10];
            for (int j = 0; j < a.length; j++) {
                int index = digit(a[j], i);
                ArrayList<Integer> inVals = l[index];
                if (inVals == null) {
                    inVals = new ArrayList<>();
                    inVals.add(a[j]);
                } else {
                    inVals.add(a[j]);
                }
                l[index] = inVals;
            }

            //copy from temp array to original array
            int k = 0;
            for (List<Integer> v : l) {
                if (v != null) {
                    for (Integer value : v) {
                        a[k++] = value;
                    }
                }
            }

        }

    }

    static int digitCount(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    static int digit(int n, int index) {
        if (index == 0)
            return n % 10;
        return (int) ((n % pow(10, index + 1)) / pow(10, index));
    }

    static long pow(int n, int x) {
        if (x == 0)
            return 1;
        if (x == 1)
            return n;
        long half = pow(n, x / 2);
        long ans = half * half;
        if (x % 2 != 0) {
            ans *= n;
        }
        return ans;
    }
}
