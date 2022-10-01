package sorting.classwise.practice;

import java.util.Arrays;

public class QuickSort {
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
        quickSort(a, 0, a.length - 1);
    }

    static void quickSort(int[] a, int start, int end) {
        if (start >= end) return;
        int position = reArrange(a, start, end);
        quickSort(a, start, position - 1);
        quickSort(a, position + 1, end);
    }

    private static int reArrange(int[] a, int start, int end) {
        int i = start + 1;
        int j = end;
        while (i <= j) {
            if (a[i] <= a[start]) {
                i++;
            } else if (a[j] > a[start]) {
                j--;
            } else {
                int tem = a[i];
                a[i] = a[j];
                a[j] = tem;
                i++;
                j--;
            }
        }
        int temp = a[start];
        a[start] = a[i - 1];
        a[i - 1] = temp;
        return i - 1;
    }
}
