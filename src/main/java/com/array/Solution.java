package com.array;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve("bobabtbobl"));
    }
    public int solve(String A) {
        int count=0;
        int i=0;
        String b="bob";
        while(i<A.length()){
            if(A.charAt(i)=='b'){
               if(isPresent(A,i,b)){
                     count++;
                 }
             }
             i++;
        }
        return count;
    }

    private boolean isPresent(String s,int index,String b){
         int j=0;
         while(index<s.length() && j<b.length()){
             if(s.charAt(index)!=b.charAt(j)){
                 return false;
             }
             index++;
             j++;
         }
         return j==2;
    }
}
