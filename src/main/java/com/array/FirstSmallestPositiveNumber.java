package com.array;

public class FirstSmallestPositiveNumber {
    public static void main(String[] args) {
        int a[]=new int[]{-1,2,3,4};
        System.out.println(findFirstSmallestPositiveNumber(a));


    }

    public static int findFirstSmallestPositiveNumber(int[] a){
        int i=0;

       while(i<a.length){
            if(a[i]>0 && a[i]<a.length+1){
                if(a[i]==i+1)
                    continue;
            }else{
                i++;
           }
        }
        System.out.println();
        return 0;
    }
}
