package search.classwise;

public class FloorOfANumber {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 8, 9};
        System.out.println(getFloor(a, 7));
    }

    static int getFloor(int[] a, int key) {
        int ans = 0;
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) / 2);
            if (a[mid] == key) {
                return a[mid];
            } else if (key > a[mid]) {
                i = mid + 1;
                ans = a[mid];
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }
}
