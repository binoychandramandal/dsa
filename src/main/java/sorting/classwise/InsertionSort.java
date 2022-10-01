package sorting.classwise;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {5, 1, 7, 2, 8, 3, 9, 4};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    static void sort(int[] a) {
        if (a == null || a.length <= 0) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int cur = a[i];
            while (j >= 0 && a[j] >= cur) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = cur;
        }

    }
}
