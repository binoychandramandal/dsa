package sorting.classwise.practice;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(b));
        sort(b);
        System.out.println(Arrays.toString(b));
    }

    static void sort(int a[]) {
        if (a == null | a.length <= 0) return;
        mergeSort(a, 0, a.length - 1);
    }

    static void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            mergeWithoutExtraSpace(a, start, mid, end);
        }
    }

    static void merge(int[] a, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] res = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = a[j++];
            }
        }
        while (i <= mid) {
            res[k++] = a[i++];
        }
        while (j <= end) {
            res[k++] = a[j++];
        }
        System.arraycopy(res, 0, a, start, res.length);
    }

    static void mergeWithoutExtraSpace(int[] a, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (a[i] >= a[j]) {
                int cur = a[i];
                a[i] = a[j];
                int k = j + 1;
                while (k <= end && a[k] < cur) {
                    a[k - 1] = a[k++];
                }
                a[k - 1] = cur;
            }
            i++;
        }
    }

}
