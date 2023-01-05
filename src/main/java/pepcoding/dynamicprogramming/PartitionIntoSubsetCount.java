package pepcoding.dynamicprogramming;

public class PartitionIntoSubsetCount {
    public static void main(String[] args) {
        System.out.println(count(4,3));
    }
    static long count(int n,int k){
        if(n==0 || k==0 || n<k){
            return 0;
        }
        long[][] dp =new long[k+1][n+1];
        for (int t = 1; t <=k ; t++) {
            for (int p = 1; p <=n; p++) {
                if(p<t){
                    dp[t][p] =0;
                }else if(p==t){
                    dp[t][p] =1;
                }else{
                    dp[t][p] =dp[t-1][p-1]+dp[t][p-1]*t;
                }
            }
        }
        return dp[k][n];
    }
}
