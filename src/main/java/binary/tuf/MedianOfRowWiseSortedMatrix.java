package binary.tuf;

public class MedianOfRowWiseSortedMatrix {
    public static void main(String[] args) {

        int[][] a={
                {1,3,6},
                {2,6,9},
                {3,6,9},
        };

        System.out.println(findMedian(a));
    }

    static int countSmallerThanEqualToMid(int[] a, int element) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (a[mid] <= element) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    static int findMedian(int[][] a) {
        int low = 0;
        int high = (int) 1e9;
        int n =a.length;
        int m=a[0].length;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int cnt =0;
            for (int i = 0; i < n; i++) {
                cnt+=countSmallerThanEqualToMid(a[i],mid);
            }
            if (cnt<=(n*m)/2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }


}
