package sorting.classwise;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {1, 5, 9};
        int[] b = {2, 3, 4, 6};
        int part[] = {1, 5, 9, 2, 3, 4, 6};
        mergeSort(part);
        System.out.println(Arrays.toString(part));
    }


    static void mergeSort(int[] a) {
        int[] t = new int[]{0};
        mergeSort0(a, 0, a.length - 1, t);
        System.out.println(t[0]);
    }

    static void mergeSort0(int[] a, int start, int end, int[] t) {
        if (start < end) {
            t[0]++;
            int mid = start + (end - start) / 2;
            mergeSort0(a, start, mid, t);
            mergeSort0(a, mid + 1, end, t);
            mergePart(a, start, mid, end);
        }
    }


    static void mergePart(int[] a, int s, int m, int end) {
        if (a == null || s < 0 || end > a.length) {
            return;
        }
        int[] result = new int[end - s + 1];
        int i = s;
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
        int p = s;
        for (int l = 0; l < result.length; l++) {
            a[p++] = result[l];
        }

    }


}
