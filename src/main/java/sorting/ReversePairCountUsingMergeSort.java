package sorting;

public class ReversePairCountUsingMergeSort {
    public static void main(String[] args) {

        System.out.println(countPair(new int[]{5, 3, 2, 1, 4}));
        System.out.println(countPair(new int[]{1,3,2,3,1}));
        System.out.println(countPair(new int[]{3,2,1,4}));
    }

    static int countPair(int[] a) {
        return countPairWithOrderIJ(a, 0, a.length - 1);
    }

    static int countPairWithOrderIJ(int[] a, int s, int e) {
        if (s >= e) {
            return 0;
        }
        int count = 0;
        int mid = (e + s) / 2;
        count += countPairWithOrderIJ(a, s, mid);
        count += countPairWithOrderIJ(a, mid + 1, e);
        count += mergeForFindPair(a, s, mid, e);
        return count;
    }

    static int mergeForFindPair(int[] a, int s, int m, int e) {
        int count = 0;
        int sArrayIndex = m + 1;
        for (int i = s; i <= m; i++) {
            while ((sArrayIndex <= e && a[i] > 2 * a[sArrayIndex])) {
                sArrayIndex++;
            }
            count += (sArrayIndex - (m + 1));
        }
        int[] res = new int[e - s + 1];
        int i = s, j = m + 1, k = 0;
        while (i <= m && j <= e) {
            if (a[i] <= a[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = a[j++];
            }
        }
        while (i <= m) {
            res[k++] = a[i++];
        }
        while (j <= e) {
            res[k++] = a[j++];
        }
        for (int l = 0; l <= (e - s); l++) {
            a[s + l] = res[l];
        }
        return count;

    }


}
