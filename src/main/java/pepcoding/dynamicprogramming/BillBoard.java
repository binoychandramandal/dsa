package pepcoding.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class BillBoard {
    public static void main(String[] args) {

    }

    static int getProfit(int m,int[] x,int []rev,int t){
        int[] dp =new int[x.length];
        int ans =0;
        dp[0]=rev[0];
        int max=0;
        for (int i = 1; i <x.length ; i++) {
            for (int j = 0; j < i; j++) {
                int dist =x[i]-x[j];
                if(dist>t){
                    max= Math.max(max,dp[j]);
                }
            }
            dp[i] =max+rev[i];
            ans =Math.max(ans,dp[i]);
        }
        return ans;
    }

    static int getProfitOptimized(int m,int[] x,int []rev,int t){
        Map<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            map.put(x[i],rev[i]);
        }
        int[] dp =new int[m+1];
        dp[0]=0;
        for (int i = 1; i <=m ; i++) {
           if(map.containsKey(i)==false){
               dp[i] =dp[i-1];
           }else{
               int boardNotInstalled =dp[i-1];
               int boardInstalled =map.get(i);
               if(i>=t+1){
                   boardNotInstalled+=dp[i-t-1];
               }
               dp[i] = Math.max(boardNotInstalled,boardInstalled);
           }
        }
        return dp[m];
    }

}
