package practise;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        displayArray(new int[]{1, 2, 3, 4, 5}, 0);
        System.out.println();
        System.out.println("----------------------");
        displayArrayReverse(new int[]{1, 2, 3, 4, 5}, 0);
        System.out.println("");
        System.out.println("-------------------------------");
        System.out.println(findMax(new int[]{1, 2, 3, 4, 5}, 0));
        System.out.println("First Occurrence of any key");
        System.out.println(firstOccurrence(new int[]{1, 2, 3, 4, 5}, 0, 5));
        System.out.println(firstOccurrence(new int[]{1, 2, 3, 4, 5}, 0, 6));

        System.out.println("Last Occurrence of any key");
        System.out.println(lastOccurrence(new int[]{1, 2, 3, 4, 5}, 4, 5));
        System.out.println(lastOccurrence(new int[]{1, 2, 3, 4, 5}, 4, 6));
        System.out.println(lastOccurrence(new int[]{1, 2, 3, 4, 5}, 4, 1));
        System.out.println("All Indices");
       int[] rest= allIndices(new int[]{1,2,3,4,3,6,3,5},0,3,0);
        System.out.println(Arrays.toString(rest));

    }

    static void displayArray(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        System.out.print(arr[i]);
        displayArray(arr, i + 1);
    }

    static void displayArrayReverse(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        displayArrayReverse(arr, i + 1);
        System.out.print(arr[i]);
    }


    static int findMax(int[] arr, int i) {
        if (i == arr.length - 1) {
            return arr[i];
        }
        return Math.max(arr[i], findMax(arr, i + 1));
    }


    static int firstOccurrence(int[] arr, int i, int key) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        } else {
            return firstOccurrence(arr, i + 1, key);
        }
    }

    static int lastOccurrence(int[] arr, int i, int key) {
        if (i < 0) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        } else {
            return lastOccurrence(arr, i - 1, key);
        }
    }


    static int[] allIndices(int[] arr, int i, int key, int csf) {
        if (i == arr.length) {
            return new int[csf];
        }
        int[] rest=null;
        if (arr[i] == key) {
            rest=allIndices(arr, i + 1, key, csf + 1);
        } else {
           rest= allIndices(arr, i + 1, key, csf);
        }
        if (arr[i] == key){
            rest[csf]=i;
        }

        return rest;
    }


}
