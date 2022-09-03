package practice;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
        sortReverse(a);
        System.out.println(Arrays.toString(a));
        Integer[] g = new Integer[]{1,2,3,10,4,5,6};
        sortArray(g);
        System.out.println(Arrays.toString(g));
    }

    static void sort(int[] a) {
        if (a == null || a.length <= 0) {
            return;
        }
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            int index = i;
            int temp = a[i];
            while (index > 0 && temp < a[index - 1]) {
                System.out.println(count++);
                a[index] = a[index - 1];
                index--;
            }
            a[index] = temp;
        }
    }
    static <T extends Comparable<T>>void sortArray(T[] a) {
        Sort.sort(a,(a1,b)->a1.compareTo(b)<1?-1:1);
    }

    static void sortReverse(int[] a) {
        if (a == null || a.length <= 0) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            int index = i;
            int temp = a[i];
            while (index > 0 && temp > a[index - 1]) {
                a[index] = a[index - 1];
                index--;
            }
            a[index] = temp;
        }
    }

}
