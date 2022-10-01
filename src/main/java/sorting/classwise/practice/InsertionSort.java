package sorting.classwise.practice;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2,3, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));


        int[] b = {1, 2, 3, 4,3, 5};
        System.out.println(Arrays.toString(b));
        sort(b);
        System.out.println(Arrays.toString(b));
    }

    static void sort(int a[]) {
        if (a == null | a.length <= 0) return;
        for (int i = 0; i < a.length; i++) {
            int j = i - 1;
            int cur = a[i];
            while (j >= 0 && a[j]>cur) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = cur;
        }
    }
}
