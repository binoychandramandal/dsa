package recurrsion.practise;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayArray {
    public static void main(String[] args) {
//        printArray(new int[]{1, 2, 3, 4, 5}, 0);
//        System.out.println("Reversed way printing");
//        printArrayReverse(new int[]{1, 2, 3, 4, 5}, 4);
//        System.out.println("Reversed way printing");
//        printArrayReverseFromO(new int[]{1, 2, 3, 4, 5}, 0);
//        System.out.println(maxOfArray(new int[]{1, 2, 3, 4, 5}, 0));
//
//        System.out.println(firstIndex(new int[]{1, 2, 3, 4, 5}, 0, 1));
//        System.out.println(firstIndex(new int[]{1, 2, 3, 4, 5}, 0, 10));
//        System.out.println(lastIndex(new int[]{1, 2, 3, 4, 5}, 4, 1));
//        System.out.println(lastIndex(new int[]{1, 2, 3, 4, 5}, 4, 5));
//        System.out.println(lastIndex(new int[]{1, 2, 3, 4, 5}, 4, 10));
//        List<Integer> r = new ArrayList<>();
//        findAllIndex(new int[]{1, 5,2,5, 3, 4, 5}, 0, 5, r);
//        System.out.println(r);
//       int[] a= findAllIndexWithoutGlobalList(new int[]{1, 5,2,5, 3, 4, 5}, 0, 0,5);
//        System.out.println(Arrays.toString(a));
        printArrayMine(new int[]{1,2,3,4,5},0);
        printArrayMine1(new int[]{1,2,3,4,5},0);
    }


    static void  printArrayMine(int[] x,int idx){
        if(idx==x.length){
            return;
        }
        System.out.print(x[idx]+" ");
        printArrayMine(x,idx+1);
    }

    static void  printArrayMine1(int[] x,int idx){
        if(idx==x.length){
            return;
        }

        printArrayMine1(x,idx+1);
        System.out.print(x[idx]+" ");
    }

    static void printArray(int[] a, int idx) {
        if (idx == a.length) {
            return;
        }
        System.out.println(a[idx]);
        printArray(a, idx + 1);
    }

    static void printArrayReverse(int[] a, int idx) {
        if (idx < 0) {
            return;
        }
        System.out.println(a[idx]);
        printArrayReverse(a, idx - 1);
    }

    static void printArrayReverseFromO(int[] a, int idx) {
        if (idx == a.length) {
            return;
        }
        printArrayReverseFromO(a, idx + 1);
        System.out.println(a[idx]);
    }

    static int maxOfArray(int[] a, int idx) {
        if (idx == a.length) {
            return 0;
        }
        return Math.max(a[idx], maxOfArray(a, idx + 1));

    }

    static int firstIndex(int[] a, int idx, int e) {
        if (idx == a.length) {
            return -1;
        }
        if (a[idx] == e) {
            return idx;
        } else
            return firstIndex(a, idx + 1, e);

    }

    static int lastIndex(int[] a, int idx, int e) {
        if (idx < 0) {
            return -1;
        }
        if (a[idx] == e) {
            return idx;
        } else
            return lastIndex(a, idx - 1, e);

    }

    static void findAllIndex(int[] a, int idx, int e, List<Integer> r) {
        if (idx == a.length) {
            return;
        }
        if (a[idx] == e) {
            r.add(idx);
        }
        findAllIndex(a, idx + 1, e, r);

    }
    static int[] findAllIndexWithoutGlobalList(int[] a, int idx,int count, int e) {
        if (idx == a.length) {
            return new int[count];
        }
        int[] iarr;
        if (a[idx] == e) {
            iarr = findAllIndexWithoutGlobalList(a, idx + 1, count + 1, e);
            iarr[count]=idx;
        }else {
            iarr = findAllIndexWithoutGlobalList(a, idx + 1, count, e);
        }
        return iarr;
    }


}
