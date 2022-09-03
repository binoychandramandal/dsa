package sorting.classwise;

import java.util.Arrays;
import java.util.Vector;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    static void sort(int[] a) {
        if (a == null || a.length <= 0) {
            return;
        }
        int count=0;
        for (int i = 0; i <a.length; i++) {
            for (int j = 0; j < a.length - i-1; j++) {
                if (a[j] > a[j + 1]) {
                    System.out.println("Iteration-> "+count++);
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j+1] = temp;
                }
            }
        }
    }
}






















