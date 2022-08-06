package array.subarray;

import java.util.Arrays;

public class Day2 {
    public static void main(String[] args) {
        System.out.println(findMaxSubArraySum(new int[]{1, 2, 3},2));
        System.out.println(findAllSubArraySum(new int[]{1, 2, 3}));

    }

    /**
     * Find  all sub arrays sum
     *
     * @param a
     */
    public static int findAllSubArraySum(int[] a) {
        System.out.println("findAllSubArraySum");
        int sum=0;
        for (int i = 0; i<a.length; i++) {
           int left=i+1;
           int right=a.length-i;
           sum+=a[i]*left*right;
        }
        return sum;
    }
    /**
     * Find  max sub arrays sum with length k
     *
     * @param a
     */
    public static int findMaxSubArraySum(int[] a, int k) {
        System.out.println("findMaxSubArraySum");
        int sum=0;
        for (int i = 0; i < k; i++) {
            sum+=a[i];
        }
        int max=sum;
        for (int i = 1; i<=a.length-k; i++) {
            int j=i+k-1;
            sum=sum-a[i-1]+a[j];
            if(sum>max){
                max=sum;
            }
        }
        return sum;
    }
    /**
     * Print start and end index of all sub arrays with length k
     *
     * @param a
     */
    public static void printSubArrayIndex(int[] a, int k) {
        System.out.println("Sub array index");
        for (int i = 0; i <=a.length-k; i++) {
            int j=i+k-1;
            System.out.println(i+" -> "+j);
        }
    }


}
