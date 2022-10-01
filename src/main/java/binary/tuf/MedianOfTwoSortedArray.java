package binary.tuf;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};
        System.out.println(getMedianOfTwoSortedArrayUsingMerge(a, b));
        System.out.println(getMedianUsingBS(a, b));
    }

    static int getMedianOfTwoSortedArrayUsingMerge(int[] a, int[] b) {
        int[] r = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                r[k++] = a[i++];
            } else {
                r[k++] = b[j++];
            }
        }
        while (i < a.length) {
            r[k++] = a[i++];
        }
        while (j < b.length) {
            r[k++] = b[j++];
        }
        int size = r.length;
        if (size % 2 == 0) {
            return (r[size / 2 - 1] + r[size / 2 - 1]) / 2;
        } else
            return r[size / 2];
    }


    static double getMedianUsingBS(int[] a, int[] b) {
        if (b.length < a.length) {
            getMedianUsingBS(b, a);
        }
        int n1 = a.length;
        int n2 = b.length;

        int low = 0, high = n1;
        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : a[cut2 - 1];
            int right1 = cut1 == n1 ? Integer.MAX_VALUE : a[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : a[cut2];
            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                } else return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}
