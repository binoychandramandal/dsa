package dynamicprogramming.knapsack;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 0 1 Knapsack problem
 */
public class EqualSumPartition {

    public static void main(String[] args) {
        int[] wt = {1,5,5,12};
        int w = 9;
        System.out.println(equalSumPartition(wt, wt.length));
    }

    /**
     * Using recursion
     *
     * @param wt
     * @param n
     * @return
     */
    public static boolean equalSumPartition(int[] wt, int n) {

        if (n == 0) {
            return true;
        }
       int sum = Stream.of(wt).collect(Collectors.summingInt(a-> Arrays.stream(a).sum()));
       if(sum%2!=0){
           return false;
       }else{
           return SubSetSum.targetSumUsingTopDown(wt,sum/2,n);
       }

    }

}
