package recurrsion.practise1;

public class ArraySort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 10, 4, 15};
         a = new int[]{1,2,3,4,5};
        sort(a);
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void sort(int[] a) {
        if (a==null || a.length <= 1) {
            return;
        }
        sort(a, 1, a.length);
    }

    static void sort(int[] a, int index, int length) {
        if (index >= length) {
            return;
        }
        if (a[index - 1] > a[index]) {
            insert(a, index - 1, index);
        }
        sort(a, index + 1, length);

    }

    static void insert(int[] a, int lessIndex, int index) {
        if (lessIndex == 0) {
            if (a[lessIndex] > a[index]) {
                swap(a, lessIndex, index);
            }
            return;
        }
        if (a[lessIndex] > a[index]) {
            swap(a, lessIndex, index);
            insert(a, lessIndex - 1, index - 1);
        }
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
