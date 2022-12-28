package pepcoding.backtracking.practice;

import java.util.ArrayList;
import java.util.List;

public class TugOfWar {

    static int minDiff =Integer.MAX_VALUE;
    static String ans ="";
    public static void main(String[] args) {
        solution(new int[]{1,2,3,4,5,6},0,new ArrayList<>(),new ArrayList<>(),0,0);
        System.out.println(ans);
    }

    static void solution(int[] arr, int vidx, List<Integer> set1, List<Integer> set2, int set1Sum, int set2Sum) {
        if (arr.length == vidx) {
             int delta =Math.abs(set1Sum-set2Sum);
             if(delta<minDiff){
                 minDiff=delta;
                 ans =set1+" "+set2;
             }
            return;
        }
        if (set1.size() < (arr.length + 1) / 2) {
            set1.add(arr[vidx]);
            solution(arr, vidx + 1, set1, set2, set1Sum + arr[vidx], set2Sum);
            set1.remove(set1.size() - 1);
        }
        if (set2.size() < (arr.length + 1) / 2) {
            set2.add(arr[vidx]);
            solution(arr, vidx + 1, set1, set2, set1Sum, set2Sum + arr[vidx]);
            set2.remove(set2.size() - 1);
        }

    }
}
