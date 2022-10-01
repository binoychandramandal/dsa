package sorting.classwise.practice;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));


        int[] b = {1,2,3,4,5};
        System.out.println(Arrays.toString(b));
        sort(b);
        System.out.println(Arrays.toString(b));
    }

    static void sort(int a[]) {
       if(a==null | a.length<=0)return;
        for (int i = 0; i < a.length; i++) {
            int idx =i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j]<a[idx]){
                    idx = j;
                }
            }
            int temp = a[i];
            a[i]=a[idx];
            a[idx] = temp;
        }
    }
}
