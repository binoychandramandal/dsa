package sorting;

import java.util.Arrays;

public class Day1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(bubbleSort(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(selectionSort(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(merge(new int[]{11,12,13,14,1,50},0,3,4)));
        int[] merge = new int[]{5,1,4,2,3};
        mergeSort(merge,0,merge.length-1);
        System.out.println(Arrays.toString(merge));
    }


    static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    flag = true;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
        }
        return a;
    }

    static int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int minIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            int tmp = a[i];
            a[i] = min;
            a[minIndex] = tmp;
        }
        return a;
    }

    static void mergeSort(int[] a,int s,int e){
         if(s==e) return;
         int mid =( e+s)/2;
         mergeSort(a,s,mid);
         mergeSort(a,mid+1,e);
         merge(a,s,mid,e);
    }

    static int[] merge(int[] a, int s, int m, int e) {
        int[] tmp = new int[e - s + 1];
        int i = s;
        int j = m+1;
        int k = 0;
        while (i <= m && j <= e) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= m) {
            tmp[k++] = a[i++];
        }

        while (j <= e) {
            tmp[k++] = a[j++];
        }

        for (int l = 0; l < tmp.length; l++) {
            a[s + l] = tmp[l];
        }
        return a;
    }

}
