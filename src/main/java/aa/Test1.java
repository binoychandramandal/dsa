package aa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test1 {

    public static void main(String[] args) {
        printPairSum(new int[]{8, 7, 2, 5, 3, 1},10);
        printPairSum(new int[]{5, 2, 6, 8, 1, 9},12);
        printPairSumUsingSort(new int[]{5, 2, 6, 8, 1, 9},12);
        printPairSumUsingSort(new int[]{8, 7, 2, 5, 3, 1,2,2},10);
        printPairSumUsingMap(new int[]{8, 7, 2, 5, 3, 1,2,2},10);
    }

    static void printPairSum(int[] a,int sum){
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]+a[j]==sum){
                    System.out.println(a[i]+" -> "+a[j]+" = "+sum);
                }
            }
        }
    }

    static void printPairSumUsingMap(int[] a,int sum){
        Set<Integer> s=new HashSet<>();
       for(Integer e:a){
           if(s.contains(sum-e)){
               System.out.println(e+"+"+(sum-e)+" = "+sum);
           }
               s.add(e);
       }
    }

    static void printPairSumUsingSort(int[] a,int sum){
        Arrays.sort(a);
        int l=0,r=a.length-1;
        while (l<r){
            int tmp =a[l]+a[r];
            if(tmp==sum){
                System.out.println(a[l]+"+"+a[r]+"="+sum);
                l++;
                r--;
            }else  if(tmp>sum){
                r--;
            }else{
                l++;
            }

        }

    }

}
