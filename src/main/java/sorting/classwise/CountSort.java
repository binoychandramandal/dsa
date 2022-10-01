package sorting.classwise;

public class CountSort {
    public static void main(String[] args) {
        //data range from 1 to 4
        int[] a = {3, 1, 4, 4, 2, 1, 3, 3, 2, 1};
        sort(a,1,4);
    }

    static void sort(int[] a, int start, int end) {
        int[] freq = new int[end + 1];
        for (int i = 0; i < a.length; i++) {
            freq[a[i]]++;
        }

        for (int i = 1; i < freq.length; i++) {
            for (int j = 1; j <=freq[i] ; j++) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}
