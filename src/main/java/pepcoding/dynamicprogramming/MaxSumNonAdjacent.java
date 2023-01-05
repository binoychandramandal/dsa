package pepcoding.dynamicprogramming;

public class MaxSumNonAdjacent {
    public static void main(String[] args) {
        System.out.println( maxSum(new int[]{5,10,10,100,5,6}));
    }

    static int maxSum(int[] arr) {
        int inc = arr[0];
        int exc = 0;
        for (int i = 1; i < arr.length; i++) {
            int ninc = exc + arr[i];
            int nexc = Math.max(inc, exc);
            inc = ninc;
            exc = nexc;
        }
        return Math.max(inc, exc);
    }
}
