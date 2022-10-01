package search.classwise;

public class PeakElement {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 8, 9};
        System.out.println(findPeakElement(a));

        int[] b = {-1, 6, 2, 5, 7, 4, 8,10,11,12,13};
        System.out.println(findPeakElement(b));
    }

    public static int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int ans = 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int next = (mid + 1) % nums.length;
            int prev = (mid - 1 + nums.length) % nums.length;
            if (nums[mid] >= nums[prev] && nums[mid] > nums[next]) {
                return nums[mid];
            } else if (nums[mid] < nums[next]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return 0;


    }
}
