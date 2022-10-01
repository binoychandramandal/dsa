package sorting.classwise;

public class InversionCount {

    public static void main(String[] args) {

        int[] a = {10, 3, 8, 15, 6, 12, 2, 18, 7, 1};
        System.out.println(findInversionPair(a));
        System.out.println(findPairUsingMergeSort(a, 0, a.length - 1));

    }

    /**
     * find All pair i<j  and a[i]>a[j]
     *
     * @param a input array
     * @return pair
     */
    static int findInversionPair(int[] a) {
        int count = 0;
        if (a == null || a.length <= 0) {
            return count;
        }
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    static int findPairUsingMergeSort(int[] a, int start, int end) {
        if (start == end) return 0;
        int mid = (start + end) / 2;
        int partAPairCount = findPairUsingMergeSort(a, start, mid);
        int partBPairCount = findPairUsingMergeSort(a, mid + 1, end);
        return partAPairCount + partBPairCount + merge(a, start, mid, end);
    }

    private static int merge(int[] a, int start, int mid, int end) {
        int count = 0;
        int i = start, j = mid + 1, k = 0;
        int[] r = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                r[k++] = a[i++];
            } else {
                r[k++] = a[j++];
                count += (mid - i + 1);
            }
        }
        while (i <= mid) {
            r[k++] = a[i++];
        }
        while (j <= end) {
            r[k++] = a[j++];
            count += (mid - i + 1);
        }
        for (int l = 0; l <(end-start+1); l++) {
            a[start+l] = r[l];
        }
        return count;
    }

}
