package pepcoding.dynamicprogramming;

public class PaintHouseWithMulticolor {

    public static void main(String[] args) {

        int n =4;
        int[][] arr =new int[][]{
            {1,5,7},
            {5,8,4},
            {3,2,9},
            {1,2,4},
        };

        System.out.println(doPaintWithMInPriceWithMultiColor(arr));
    }

    static long doPaintWithMInPriceWithMultiColor(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
       int least =Integer.MAX_VALUE;
       int sLeast =Integer.MAX_VALUE;
        for (int j = 0; j < arr[0].length; j++) {
            dp[0][j] =arr[0][j];
            if(arr[0][j]<=least){
                sLeast=least;
                least =arr[0][j];
            }else if(arr[0][j]<=sLeast){
                sLeast =arr[0][j];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            int nLeast =Integer.MAX_VALUE;
            int nSLeast =Integer.MAX_VALUE;
            for (int j = 0; j < dp[0].length; j++) {
                if(least==dp[i-1][j]){
                    dp[i][j] = sLeast+ arr[i][j];
                }else{
                    dp[i][j] = least+ arr[i][j];
                }
                if(dp[i][j]<=nLeast){
                    nSLeast=nLeast;
                    nLeast =dp[i][j];
                }else if(dp[i][j]<=nSLeast){
                    nSLeast =dp[i][j];
                }
            }
            least =nLeast;
            sLeast =nSLeast;
        }
        return least;
    }
}
