package sorting.classwise;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] a = {3, 8, 6, 2, 7, 10, 14, 15, 18, 12, 15};
        int[] b = {3, 8, 6, 2, 3, 10, 14, 15, 18, 12, 3};
        System.out.println(Arrays.toString(a));
        System.out.println("Transforming");
        int position = reArrange1(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b) + " Position-> " + position);
        int[] c = {3, 8, 6, 2, 7, 10, 14, 15, 18, 12, 15};
        System.out.println(Arrays.toString(c));
        quickSort(c,0,c.length-1);
        System.out.println(Arrays.toString(c));
    }

    /**
     * With extra space
     *
     * @param a
     * @return
     */
    static int[] reArrange(int[] a) {
        int[] result = new int[a.length];
        int l = 0, r = a.length - 1;
        for (int i = 1; i < a.length; i++) {
            if (a[l] <= a[0]) {
                result[l++] = a[i];
            } else if (a[r] > a[0]) {
                result[r--] = a[i];
            }
        }
        result[l] = a[0];
        System.arraycopy(result, 0, a, 0, a.length);
        return a;
    }


    /**
     * Without extra space
     *
     * @param a
     * @return
     */
    static int[] reArrange1(int[] a) {
        int i = 1, j = a.length - 1;
        while (i <= j) {
            if (a[i] <= a[0]) {
                i++;
            } else if (a[j] > a[0]) {
                j--;
            } else {
                System.out.println("aya");
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        int temp = a[0];
        a[0] = a[i - 1];
        a[i - 1] = temp;
        return a;
    }

    /**
     * Without extra space
     *
     * @param a
     * @return
     */
    static int reArrange1(int[] a, int start, int end) {
        int i = start + 1, j = end;
        while (i <= j) {
            if (a[i] <= a[start]) {
                i++;
            } else if (a[j] > a[start]) {
                j--;
            } else {
                System.out.println("aya");
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        int temp = a[start];
        a[start] = a[i - 1];
        a[i - 1] = temp;
        return i - 1;
    }

    static void quickSort(int[] a, int start, int end) {
        if (start >= end) return;
        int position = reArrange1(a, start, end);
        quickSort(a, start, position - 1);
        quickSort(a, position + 1, end);
    }

}
