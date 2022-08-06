package pepcoding.dynamicprogramming;

public class TargetSumSubset {
    public static void main(String[] args) {
        int[]arr = new int[]{1,2,3,4,5};
        System.out.println(isPresentSubset(arr,100));

    }


    static boolean isPresentSubset(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                }
                else {
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        int val = arr[i - 1];
                        if (val>= j) {
                            if (dp[i - 1][j - val] = true) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        print(dp);
        return dp[arr.length][target];
    }

    static void print(boolean[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
}
