package sorting;

import java.util.*;

public class Sorting5 {
    public static void main(String[] args) {
        int[] a = new int[]{10, 3, 8, 15, 6, 12, 2, 18, 7, 1};
        //int[] a = new int[]{8, 1, 4, 7};
         rearrange(a);
        //quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    static void quickSort(int[] a, int s, int e) {
        if (s >= e) return;
        int p = rearrange(a, s, e);
        quickSort(a, s, p - 1);
        quickSort(a, p + 1, e);
    }

    static void rearrange(int[] a) {
        int l = 1, r = a.length - 1;
        while (l <= r) {
            if (a[l]<=a[0]) {
                l++;
            } else if (a[r]>a[0]) {
                r--;
            } else {
                int tmp = a[l];
                a[l] = a[r];
                a[r] = tmp;
                l++;
                r--;
            }
        }
        int tmp = a[0];
        a[0] = a[l - 1];
        a[l - 1] = tmp;
    }

    static int rearrange(int[] a, int s, int e) {
        int i = s + 1, j = e;
        while (i <= j) {
            if (a[s] >= a[i]) {
                i++;
            } else if (a[s] < a[j]) {
                j--;
            } else {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }
        }
        int tmp = a[s];
        a[s] = a[i - 1];
        a[i - 1] = tmp;
        return i - 1;
    }


}