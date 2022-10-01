package binary.tuf;

public class SingleElementInSortedArray {
    public static void main(String[] args) {

        int[]a ={1,1,2,3,3};
        System.out.println(findSingleElementWhichAppearOnce(a));

        int[]b ={1,2,2,3,3};
        System.out.println(findSingleElementWhichAppearOnce(b));

    }

    static int findSingleElementWhichAppearOnce(int[] a) {
        int low = 0;
        int high = a.length - 2;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (a[mid] == a[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return a[low];
    }
}
