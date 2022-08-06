package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOf1 {
    public static void main(String[] args) {
//        int[] a = new int[10];
//        for (int i = 0; i < a.length; i++) {
//            //a[i]=1;
//        }
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(a));
//        System.out.println(firstOccuranceOf0(a));
//        System.out.println(countOf1(a));
        int[] a1 = new int[]{0, 1, 1, 0, 0, 1, 0, 0, 1, 0};

        System.out.println(max1(a1));

        System.out.println(-60 % 9);

        System.out.println(printFactorOfANumber(0));
    }

    static List<Integer> printFactorOfANumber(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                result.add(i);
                if(i!=(n/i))
                result.add(n / i);
            }
        }
        return result;
    }


    static int max1(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                count++;
            }
            if (a[i] == 0) {
                a[i] = 1;
            } else {
                a[i] = -1;
            }
        }
        return count + kadane(a);
    }

    static int kadane(int[] a) {

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    static int countOf1(int[] a) {
        int count = firstOccuranceOf0(a);
        return count == -1 ? a.length : a.length - count;
    }

    static int firstOccuranceOf0(int[] a) {
        int s = 0;
        int e = a.length - 1;
        int index = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] == 0) {
                e = mid - 1;
                index = mid;
            } else {
                s = mid + 1;
            }
        }
        return index;
    }
}
