package sorting.classwise.practice;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));


        int[] b = {1,2,3,4,5};
        System.out.println(Arrays.toString(b));
        sort(b);
        System.out.println(Arrays.toString(b));
    }

    static void sort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    flag = false;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            if (flag == true) {
                break;
            }
        }
    }
}
