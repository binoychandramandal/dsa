package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {
    public static void main(String[] args) {

        System.out.println(countPairWithOrder(new int[]{10, 3, 8, 15, 6, 12, 2, 18, 7, 1}));
        int[] count = new int[]{10, 3, 8, 15, 6, 12, 2, 18, 7, 1};
        System.out.println(countPairWithOrderIJ(count,0,count.length-1));
        System.out.println(Arrays.toString(count));

        int[] a = new int[]{5, 4, 3, 2, 1};
        a = new int[]{1, 2, 3, 4, 5, 6};
        a = new int[]{2, 1};
        a = new int[]{1};
        a = new int[]{-11, 0, -12};
        mergeSort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));


        System.out.println(findPairCount(new int[]{7, 3, 5}, new int[]{2, 0, 6}));
        System.out.println(findPairCount(new int[]{8, 5, 3, 10}, new int[]{6, 4, 9, 2}));
        System.out.println(findPairCount(new int[]{2, 3}, new int[]{10, 20}));
        System.out.println(findPairCount(new int[]{7, 8, 2, 4}, new int[]{3, 5, 1, 10}));

        Integer[] l = new Integer[]{8, 89};

        Arrays.sort(l, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int s1 = Integer.parseInt(o1 + "" + o2);
                int s2 = Integer.parseInt(o2 + "" + o1);
                return s1 == s2 ? 0 : s1 < s2 ? 1 : -1;
            }
        });
        System.out.println(Arrays.toString(l));
    }

    static int countPairWithOrder(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    static int countPairWithOrderIJ(int[] a, int s, int e) {
        if (s == e) return 0;
        int mid = (e+s) / 2;
        int countInPartA = countPairWithOrderIJ(a, s, mid);
        int countInPartB = countPairWithOrderIJ(a, mid + 1, e);
        return countInPartA + countInPartA + mergeForFindPair(a,s,mid,e);
    }

    static int mergeForFindPair(int[] a, int s, int m,int e) {
        int[] res = new int[e - s + 1];
        int i = s, j = m + 1, k = 0;
        int count = 0;
        while (i <= m && j <= e) {
            if (a[i] <= a[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = a[j++];
                count += (m-i + 1);
            }
        }
        while (i <= m) {
            res[k++] = a[i++];
        }

        while (j <= e) {
            res[k++] = a[j++];
        }
        for (int l = 0; l <=(e-s); l++) {
            a[s + l] = res[l];
        }
        return count;

    }

    static int findPairCount(int[] a, int[] b) {
        mergeSort(a, 0, a.length - 1);
        mergeSort(b, 0, b.length - 1);
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[a.length + b.length];
        int count = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
                count += a.length - i;
            }
        }
        while (i < a.length) {
            res[k++] = a[i++];
        }
        while (j < b.length) {
            res[k++] = b[j++];
            count += a.length - i;
        }
        System.out.println(Arrays.toString(res));
        return count;
    }

    static void merge(int[] a, int s, int e) {
        int[] result = new int[e - s + 1];
        int i = s;
        int mid = (s + e) / 2;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= e) {
            if (a[i] < a[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = a[j++];
            }
        }
        while (i <= mid) {
            result[k++] = a[i++];
        }
        while (j <= e) {
            result[k++] = a[j++];
        }

        for (int l = 0; l < result.length; l++) {
            a[s + l] = result[l];
        }
    }


    public static void mergeSort(int a[], int s, int e) {
        if (s == e) return;
        int mid = (s + e) / 2;
        mergeSort(a, s, mid);
        mergeSort(a, mid + 1, e);
        merge(a, s, e);
    }
}
