package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class InversionCountUsingMergeSort {
    public static void main(String[] args) {

        //System.out.println(countPairWithOrder(new int[]{10, 3, 8, 15, 6, 12, 2, 18, 7, 1}));
        //int[] count = new int[]{10, 3, 8, 15, 6, 12, 2, 18, 7, 1};
       // System.out.println(countPairWithOrderIJ(count,0,count.length-1));
        //System.out.println(countPair(new int[]{1,2,3,4,5}));
        //System.out.println(countPair(new int[]{5,4,3,2,1}));
        System.out.println(countPair(new int[]{5,3,2,1,4}));
        System.out.println(countPairWithOrder(new int[]{5,3,2,1,4}));
    }

    static int countPairWithOrder(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }


    static int countPair(int[] a) {
       return countPairWithOrderIJ(a,0,a.length-1);
    }

    static int countPairWithOrderIJ(int[] a, int s, int e) {
        int count=0;
        if(e>s) {
            int mid = (e + s) / 2;
            count+= countPairWithOrderIJ(a, s, mid);
            count+= countPairWithOrderIJ(a, mid + 1, e);
            count+=mergeForFindPair(a, s, mid, e);
            return count;
        }
        return count;
    }

    static int mergeForFindPair(int[] a, int s, int m,int e) {
        int[] res = new int[e - s + 1];
        int i = s, j = m + 1, k = 0;
        int count = 0;
        while (i <= m && j <= e) {
            if (a[i] <= a[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = a[j++];
            }
        }

        while (j <= e) {
            res[k++] = a[j++];
            count += (m-i+1);
        }
        while (i <= m) {
            res[k++] = a[i++];
        }
        for (int l = 0; l <=(e-s); l++) {
            a[s + l] = res[l];
        }
        return count;

    }


}
