package practise.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Print {
    public static void main(String[] args) {
        //printIncrement(10);
        //printDecrement(10);
        //printInDe(10);
        //System.out.println(fact(5));
        // System.out.println(pow(2, 3));
        //System.out.println(powUsingLog(2, 3));
        //printTowerOfHanoi(3, "A", "B", "C");
        // displayIncreasingOrder(new int[]{1,2,3,4,5},0);
        // displayDecreasing(new int[]{1,2,3,4,5},0);
        //System.out.println(max(new int[]{1,10,3,4,5},0));
        // System.out.println(firstIndex(new int[]{1,10,3,4,5},0,10));
        //System.out.println(firstIndex(new int[]{1,10,3,4,5},0,100));
        // System.out.println(lastIndex(new int[]{1,10,3,4,5},0,5));
        //System.out.println(lastIndex(new int[]{1,10,3,4,5},0,1));
        //System.out.println(Arrays.toString(getAllIndex(new int[]{1,2,3,4,5,1,2,1},0,1,0)));
        //printSubSequence("abc", "");
        System.out.println(printSubSequence("abc"));
    }

    static void printIncrement(int n) {
        if (n == 0)
            return;
        printIncrement(n - 1);
        System.out.println(n);
    }

    static void printDecrement(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        printDecrement(n - 1);
    }

    static void printInDe(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printInDe(n - 1);
        System.out.println(n);
    }

    static int fact(int n) {
        return n == 0 ? 1 : n * fact(n - 1);
    }

    static int pow(int x, int y) {
        return y == 0 ? 1 : x * pow(x, y - 1);
    }

    static long powUsingLog(int x, int y) {
        if (y == 0) {
            return 1;
        }
        long half = powUsingLog(x, y / 2);
        return y % 2 == 0 ? half * half : x * half * half;
    }


    static void printTowerOfHanoi(int n, String src, String temp, String dest) {
        if (n == 0)
            return;
        printTowerOfHanoi(n - 1, src, dest, temp);
        System.out.println(n + " dick move from " + src + " to " + dest);
        printTowerOfHanoi(n - 1, temp, src, dest);
    }

    static void displayIncreasingOrder(int[] a, int index) {
        if (index == a.length) {
            return;
        }
        System.out.print(a[index] + " ");
        displayIncreasingOrder(a, index + 1);
    }

    static void displayDecreasing(int[] a, int index) {
        if (index == a.length) {
            return;
        }
        displayDecreasing(a, index + 1);
        System.out.print(a[index] + " ");
    }

    static int max(int[] a, int index) {
        if (index == a.length) {
            return Integer.MIN_VALUE;
        }
        return Math.max(a[index], max(a, index + 1));
    }

    static int firstIndex(int[] a, int index, int data) {
        if (index == a.length) {
            return -1;
        }
        if (a[index] == data)
            return index;
        return firstIndex(a, index + 1, data);
    }

    static int lastIndex(int[] a, int index, int data) {
        if (index == a.length) {
            return -1;
        }
        int ind = lastIndex(a, index + 1, data);
        if (ind == -1 && a[index] == data) {
            return index;
        }
        return ind;
    }

    static int[] getAllIndex(int a[], int index, int data, int fsf) {
        if (index == a.length) {
            return new int[fsf];
        }
        if (a[index] == data) {
            int[] t = getAllIndex(a, index + 1, data, fsf + 1);
            t[fsf] = index;
            return t;
        } else {
            return getAllIndex(a, index + 1, data, fsf);
        }
    }

    static void printSubSequence(String str, String fsf) {
        if (str.isEmpty()) {
            System.out.println(fsf);
            return;
        }
        printSubSequence(str.substring(1), fsf + str.charAt(0));
        printSubSequence(str.substring(1), fsf);
    }

    static List<String> printSubSequence(String str) {
        if (str.isEmpty()) {
            List<String> l = new ArrayList<>();
            l.add("");
            return l;
        }
        char c =str.charAt(0);
       List<String> res =  printSubSequence(str.substring(1));
        List<String> col = new ArrayList<>();
        for (String s:res) {
            col.add(s);
        }
        for (String s:res) {
            col.add(c+s);
        }
        return col;
    }

}
