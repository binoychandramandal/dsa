package practise.backtracking;

import java.util.Arrays;

public class DisplayArrayInCreasingOrder {
    public static void main(String[] args) {
        display(new int[]{1, 2, 3, 4, 5}, 0);
        displayReverse(new int[]{1, 2, 3, 4, 5}, 0);
        displayReverse(new int[]{1, 2, 3, 4, 5}, 0);
        System.out.println("Max " + maxInArray(new int[]{1, 2, 3, 4, 5}, 0));
        System.out.println("First Index: " + firstIndex(new int[]{1, 2, 3, 4, 5}, 0, 2));
        System.out.println("First Index: " + firstIndex(new int[]{1, 2, 3, 4, 5}, 0, 6));
        System.out.println("Last Index: " + lastIndex(new int[]{1, 2, 3, 4, 5}, 0, 6));
        System.out.println("Last Index: " + lastIndex(new int[]{1, 2, 3, 4, 5}, 0, 1));
        System.out.println("Last Index: " + Arrays.toString(getAllIndex(new int[]{1, 2, 1, 4, 1}, 0, 1,0)));
    }

    static void display(int[] a, int index) {
        if (index == a.length) {
            return;
        }
        System.out.println(a[index]);
        display(a, index + 1);
    }

    static void displayReverse(int[] a, int index) {
        if (index == a.length) {
            return;
        }
        displayReverse(a, index + 1);
        System.out.println(a[index]);
    }

    static int maxInArray(int[] a, int index) {
        return index == a.length ? Integer.MIN_VALUE : Math.max(a[index], maxInArray(a, index + 1));
    }

    static int firstIndex(int[] a, int index, int data) {
        if (index == a.length) {
            return -1;
        }
        if (a[index] == data) {
            return index;
        }
        return firstIndex(a, index + 1, data);
    }

    static int lastIndex(int[] a, int index, int data) {
        if (index == a.length) {
            return -1;
        }
        int ind = lastIndex(a, index + 1, data);
        if(ind==-1 && a[index]==data){
            return index;
        }
        return ind;
    }

    static int[] getAllIndex(int[] a,int index,int data,int fsf){
        if(a.length==index){
            return new int[fsf];
        }
        if(a[index]==data){
            int [] res= getAllIndex(a,index+1,data,fsf+1);
            res[fsf]=index;
           return res;
        }else{
            return getAllIndex(a,index+1,data,fsf);
        }
    }
}
