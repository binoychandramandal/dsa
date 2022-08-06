package twopointer;

import java.util.Arrays;

public class ThreeSortedArrayMinimized {
    public static void main(String[] args) {
      int[] a=new int[]{3,14,16,20,29,40};
      int[] b=new int[]{-6,23,24,30,35,50};
      int[] c=new int[]{-15,15,26,31,39,42};
        System.out.println(min(a,b,c));

         int[] t=new int[]{1,2,3,7,9,3};
        shiftRight(t,3);
        System.out.println(Arrays.toString(t));
    }


    static void shiftRight(int[] a,int b){
        int p1=0,p2=a.length-1;
        while(p1<p2){
            if(a[p1]!=b){
                p1++;
            }else if(a[p2]==b){
                p2--;
            }else{
                int t=a[p1];
                a[p1]=a[p2];
                a[p2]=t;
                p1++;
                p2--;
            }
        }
    }

    static int min(int[] a, int[] b, int[] c) {
        int p1 = 0, p2 = 0, p3 = 0, ans = Integer.MAX_VALUE;
        while (p1 < a.length && p2 < a.length && p3 < a.length) {
            int max = Math.max(Math.max(a[p1], b[p2]), c[p3]);
            int min = Math.min(Math.min(a[p1], b[p2]), c[p3]);
            ans = Math.min(ans, max - min);
            if (a[p1] < b[p2] && a[p1] < c[p3]) {
                p1++;
            } else if (b[p2] < a[p1] && b[p2] < c[p3]) {
                p2++;
            } else {
                p3++;
            }
        }
        return ans;
    }


}
