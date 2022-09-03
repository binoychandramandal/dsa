package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static <T extends Comparable<T>> void sort(List<T> list, Comparator<T> comparator) {
        list.sort(comparator);
    }

    public static <T extends Comparable<T>> void sort(T[] a, Comparator<T> comparator) {
        Arrays.sort(a,comparator);
    }
}
