package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseEntireArray(new int[]{-3, 2, 5, 6, 7, 8})));

    }

    /**
     * Reverse entire array
     *
     * @param a array
     * @return reversed array
     */
    public static int[] reverseEntireArray(int[] a) {
        //find max element
        if (a == null || a.length == 0) {
            return a;
        }
        int i = 0;
        int j = a.length - 1;
        int temp = 0;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return a;
    }

}
