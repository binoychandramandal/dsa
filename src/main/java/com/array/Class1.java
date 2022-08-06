package com.array;

public class Class1 {
    public static void main(String[] args) {
        int count = countNoOfElementGreater(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(count);
        boolean exists = existsPair(new int[]{1, 2, 3, 4, 5, 6}, 4);
        System.out.println(exists);

        int[] sorted =  reverseEntireArray(new int[]{5,4,3,2,1});
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i]);
        }
        System.out.println();
        sorted =  reverseEntireArray(new int[]{6,5,4,3,2,1});
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i]);
        }


    }

    /**
     * Count no of element having at lest 1 element greater than itself
     *
     * @param a array
     * @return count of such element
     */
    public static int countNoOfElementGreater(int[] a) {
        //find max element
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        //find max element count;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                count++;
            }
        }
        return a.length - count;
    }

    /**
     * Given an array,check if there exists a pair(i,j) such that a[i]+a[j]=k and i!=j
     *
     * @param a array
     * @return boolean
     */
    public static boolean existsPair(int[] a, int sum) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Given an array,reverse entire array
     *
     * @param a array
     * @return boolean
     */
    public static int[] reverseEntireArray(int[] a) {
        int tmp[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            tmp[i] = a[i];
        }
        int i=0;
        int j=a.length-1;
        while(i<j){
            int value = tmp[i];
            tmp[i] = tmp[j];
            tmp[j] = value;
            i++;
            j--;
        }
        return tmp;
    }

}
