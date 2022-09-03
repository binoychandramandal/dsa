package sorting.classwise;

public class PairFinding {
    public static void main(String[] args) {
        int[] a = {7, 8, 2, 4};
        int[] b = {3, 5, 1, 10};
        System.out.println(findPair(a, b));
    }

    static int findPair(int[] a, int[] b) {
        MergeSort.mergeSort(a);
        MergeSort.mergeSort(b);
        int count = 0;
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < a[j]) {
                i++;
            } else {
                count += a.length - i;
                j++;
            }
        }
        while (i < a.length) {
            i++;
        }
        while (j < b.length) {
            count += a.length - i;
            j++;
        }
        return count;
    }
}
