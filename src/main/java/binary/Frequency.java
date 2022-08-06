package binary;

public class Frequency {
    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, 3, 3, 3, 4, 5, 6, 8};
        System.out.println(frequency(a, 4));
    }

    static int frequency(int[] a, int key) {
        int firstIndex = firstOccurance(a, key);
        int secondIndex = lastOccurance(a, key);
        return secondIndex == -1 && firstIndex == -1 ? 0 : secondIndex - firstIndex + 1;
    }

    static int firstOccurance(int[] a, int key) {
        int s = 0;
        int e = a.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] == key) {
                ans = mid;
                e = mid - 1;
            } else if (a[mid] > key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    static int lastOccurance(int[] a, int key) {
        int s = 0;
        int e = a.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] == key) {
                ans = mid;
                s = mid + 1;
            } else if (a[mid] > key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}
