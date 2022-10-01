package sorting.classwise.practice;

import java.util.Arrays;

public class CountSort {
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
        countSort(a, 1,5);
    }

    static void countSort(int[] a, int start, int end) {
        int[] freq = new int[end + 1];
        for (int i = 0; i < a.length; i++) {
            freq[a[i]]++;
        }
        for (int i = 1; i < freq.length; i++) {
            for (int j = 0; j < freq[i]; j++) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }


}
