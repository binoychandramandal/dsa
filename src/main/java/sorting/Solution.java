package sorting;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(-1);
        l.add(0);
        l.add(1);
        l.add(2);
        l.add(-1);
        l.add(4);
        System.out.println(threeSum(l));
    }

    static public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Set<ArrayList<Integer>> result = new HashSet<>();
        for (int i = 0; i < A.size() - 1; i++) {
            Set<Integer> cache = new HashSet<>();
            for (int j = i + 1; j < A.size(); j++) {
                ArrayList<Integer> l = new ArrayList<>();
                int target = -(A.get(i) + A.get(j));
                if (cache.contains(target)) {
                    l.add(A.get(i));
                    l.add(A.get(j));
                    l.add(target);
                    Collections.sort(l);
                    result.add(l);
                } else {
                    cache.add(A.get(j));
                }
            }
        }
        ArrayList<ArrayList<Integer>> result1 = new ArrayList<>();
        for (ArrayList<Integer> l : result) {
            result1.add(l);
        }
        return result1;
    }


}