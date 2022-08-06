package sorting;

import java.util.Arrays;

public class InPlaceMerge {

    public static void main(String[] args) {
        int[] x = new int[]{8, 9, 10, 11};
        int[] y = new int[]{4, 5, 6};
        //merge(x, y);
        x= new int[]{8,9,1,2,3};
        merge(x, 0,x.length/2-1,x.length-1);
        System.out.println(Arrays.toString(x));
       // System.out.println(Arrays.toString(y));
    }

    static void merge(int[] x, int s, int m, int e) {
        int len = m - s + 1;
        for (int i = s; i <= len; i++) {
            if (x[i] > x[m + 1]) {
                int temp = x[i];
                x[i] = x[m + 1];
                x[m + 1] = temp;
            }
            int first = x[m+1];
            //if ((e - m > 1)) {
                int k = m + 2;
                while (k <= e && x[k] < first) {
                    x[k - 1] = x[k];
                    k++;
                }
                x[k - 1] = first;
           // }
        }
    }

    static void merge(int[] x, int[] y) {
        int xLen = x.length - 1;
        int yLen = y.length - 1;
        for (int i = 0; i <= xLen; i++) {
            if (x[i] > y[0]) {
                int temp = x[i];
                x[i] = y[0];
                y[0] = temp;
            }
            int first = y[0];
            int k = 1;
            while (k <= yLen && y[k] < first) {
                y[k - 1] = y[k];
                k++;
            }
            y[k - 1] = first;
        }
    }

}
