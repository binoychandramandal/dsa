package com.array;

public class Kadane {

    public static void main(String[] args) {
        System.out.println(getMaxSumSubArray(new int[]{-8, -3, -6, -2, -5, -4}));
    }



    public static int getMaxSumSubArray(int[] a){

        int sum=a[0];
        int ans =Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
            ans=Math.max(ans,sum);
            if(sum<0){
                sum=0;
            }
        }
        return ans;

    }

}
