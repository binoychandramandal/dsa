package sorting;

public class Sorting2 {
    public static void main(String[] args) {
        int[] a = new int[]{10, 3, 8, 15, 6, 12, 2, 18, 7, 1};
        System.out.println(findPair(a, 0, a.length - 1));

    }

    static int findPair(int[] a, int s, int e) {
        if (s == e) return 0;
        int mid = (s + e) / 2;
        int aa = findPair(a, s, mid);
        int bb = findPair(a, mid + 1, e);
        return aa + bb + merge(a, s, mid, e);
    }

    static int merge(int[] a, int s, int m, int e) {
        int i = s, j = m + 1, k = 0;
        int[] r = new int[e - s + 1];
        int count = 0;
        while (i <= m && j <= e) {
            if (a[i] <= a[j]) {
                r[k++] = a[i++];
            } else {
                r[k++] = a[j++];
                count = count + (m - i + 1);
            }
        }
        while (i <= m) {
            r[k++] = a[i++];
        }
        while (j <= e) {
            r[k++] = a[j++];
        }
        for (int l = 0; l <= (e - s); l++) {
            a[s + l] = r[l];
        }
        return count;
    }


}
