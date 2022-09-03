package sorting.classwise;

import java.util.Arrays;

public class ConcatStringToMakeBiggerNumber {
    public static void main(String[] args) {
        String[] a = {"33", "90", "39"};
        sort(a);
        System.out.println(Arrays.toString(a));
        String[] b = {"38", "31", "35"};
        sort(b);
        System.out.println(Arrays.toString(b));

        String[] c = {"30", "303", "3003"};
        sort(c);
        System.out.println(Arrays.toString(c));

        String[] c1 = {"303", "303","303"};
        sort(c1);
        System.out.println(Arrays.toString(c1));
    }

    static <T extends Comparable<T>> void sort(T[] a) {
        Arrays.sort(a, (k, v) -> {
            int x = Integer.parseInt(k + "" + v);
            int y = Integer.parseInt(v + "" + k);
            if (x - y >= 1) {
                return -1;
            } else if (x - y <= -1) {
                return 1;
            }
            System.out.println("Comming");
            return 0;
        });
    }
}
