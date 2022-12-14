package pepcoding.dynamicprogramming;

public class TilingWithDominosesM1 {
    public static void main(String[] args) {
        System.out.println(tileUp(8,3));
    }

    static int tileUp(int n,int m){
        int[] dp =new int[n+1];
        for (int i = 1; i <= n; i++) {
            if(i<m){
                dp[i] =1;
            }else if(i==m){
                dp[i] =2;
            }else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        return dp[n];
    }
}
