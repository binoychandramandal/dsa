package twopointer;

public class MaxWater2Walls {
    public static void main(String[] args) {
        System.out.println(getMaxWaterBetween2Walls(new int[]{3,5,4,7,3,6,5,4,1,2}));
    }

    static int getMaxWaterBetween2Walls(int[] a) {
        int p1 = 0;
        int p2 = a.length - 1;
        int ans = 0;
        while (p1 < p2) {
            int height = Math.min(a[p1], a[p2]);
            int width = p2 - p1;
            ans = Math.max(ans, height * width);
            if (a[p1] < a[p2]) {
                p1++;
            } else {
                p2--;
            }
        }
        return ans;
    }
}

