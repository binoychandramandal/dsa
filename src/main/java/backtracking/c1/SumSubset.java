package backtracking.c1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumSubset {

    public static void main(String[] args) {
        //int x=countSubSet(0, new int[]{10, 2, 7, 6, 1, 5}, 0, 8, "");
        //System.out.println(x);
        List<List<Integer>> subSet=new ArrayList<>();
        printAllSubSet(subSet,new int[]{1,2,3},0,new ArrayList<>());
        Collections.sort(subSet,(o1,o2)->{
            int n =Math.min(o1.size(),o2.size());
            for (int i = 0; i < n; i++) {
                if(o1.get(i)==o2.get(i)){
                    continue;
                }
                return o1.get(i)-o2.get(i);
            }
            return o1.size()-o2.size();
        });
        System.out.println(subSet);
    }

    static void printAllSubSet(List<List<Integer>> subSet,int[] item, int pos, List<Integer> asf){
        if(pos==item.length){
            System.out.println(asf);
            subSet.add(new ArrayList<>(asf));
            return;
        }
        asf.add(item[pos]);
        printAllSubSet(subSet,item,pos+1,asf);
        asf.remove(asf.size()-1);
        printAllSubSet(subSet,item,pos+1,asf);
    }

    static int countSubSet(int i, int[] item, int ssf, int k, String asf) {
        if (i == item.length) {
            if (ssf == k) {
                System.out.println(asf);
                return 1;
            } else {

                return 0;
            }
        }
        int x = countSubSet(i + 1, item, ssf + item[i], k, asf + item[i] + ".");
        x += countSubSet(i + 1, item, ssf, k, asf);
        return x;
    }
}
