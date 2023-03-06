package backtracking.c1;

import java.util.Arrays;

public class LastIndex {
    public static void main(String[] args) {
        System.out.println(lastIndex(new int[]{1, 2, 3, 4}, 0, 6));

        System.out.println(Arrays.toString(allIndex(new int[]{4, 2, 3, 4}, 0, 4,0)));
    }

    static int lastIndex(int[] a, int i, int data) {
        if (i == a.length) {
            return -1;
        }
        int index = lastIndex(a, i + 1, data);
        return (index == -1 && a[i] == data) ? i : index;
    }

    static int[] allIndex(int[] a, int i, int data, int count) {
        if (i == a.length) {
            return new int[count];
        }
        int[] rem = allIndex(a, i + 1, data, a[i] == data ? count + 1 : count);
        if (a[i] == data) {
            rem[count] = i;
        }
        return rem;
    }
}
