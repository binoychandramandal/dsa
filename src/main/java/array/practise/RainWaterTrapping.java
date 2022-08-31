package array.practise;

public class RainWaterTrapping {
    public static void main(String[] args) {
        System.out.println(getTotalWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(getTotalWaterUsingPrefixSuffixSum(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(getTotalWaterUsingTwoPointer(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

    }

    static int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }

    static int getTotalWaterUsingTwoPointer(int[] a) {
        if (a.length <= 0) {
            return 0;
        }
        int n = a.length;
        int leftMax = 0, rightMax = 0;
        int right=n-1;
        int left=0;
        int totalWater = 0;
        while (left<=right){
            if(a[left]<=a[right]){
                if(a[left]>=leftMax){
                    leftMax=a[left];
                }else{
                    totalWater+=leftMax-a[left];
                }
                 left++;
            }else{
                if(a[right]>=rightMax){
                    rightMax=a[right];
                }else{
                    totalWater+=rightMax-a[right];
                }
                right--;
            }

        }
        return totalWater;
    }

    static int getTotalWater(int[] a) {
        if (a.length <= 0) {
            return 0;
        }
        int n = a.length;
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int maxLef = 0, maxRight = 0;
            int j = i;
            while (j >= 0) {
                maxLef = Math.max(maxLef, a[j]);
                j--;
            }

            j = i;
            while (j<n) {
                maxRight = Math.max(maxRight, a[j]);
                j++;
            }
           totalWater+=Math.min(maxLef,maxRight)-a[i];

        }
        return totalWater;
    }


    static int getTotalWaterUsingPrefixSuffixSum(int[] a) {
        if (a.length <= 0) {
            return 0;
        }
        int n = a.length;
       int[] p =new int[n];
       int[] s =new int[n];
       p[0]=a[0];
       s[n-1]=a[n-1];
        for (int i = 1; i < n; i++) {
            p[i] = Math.max(p[i-1],a[i]);
        }

        for (int i = n-2; i >=0; i--) {
            s[i] = Math.max(s[i+1],a[i]);
        }
        int totalWater=0;
        for (int i = 0; i < n; i++) {
              totalWater+=Math.min(p[i],s[i])-a[i];
        }
        return totalWater;
    }
}
