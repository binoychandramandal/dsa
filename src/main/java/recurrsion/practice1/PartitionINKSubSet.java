package recurrsion.practice1;

import java.util.ArrayList;
import java.util.List;

public class PartitionINKSubSet {
    public static void main(String[] args) {
        int n=5;
        int k=4;
        List<List<Integer>> l =new ArrayList<>();
        for (int i = 0; i < k; i++) {
            l.add(new ArrayList<>());
        }
        printSubSet(n,1,k,0,l);
    }

    static void printSubSet(int n, int i, int k, int notEmptySetCount, List<List<Integer>> ans){
        if(i>n){
            if(k==notEmptySetCount){
                System.out.println(ans);
            }
            return;
        }

        for (int j = 0; j < ans.size(); j++) {
            if(ans.get(j).size()>0){
                ans.get(j).add(i);
                printSubSet(n,i+1,k,notEmptySetCount,ans);
                ans.get(j).remove(ans.get(j).size()-1);
            }else{
                ans.get(j).add(i);
                printSubSet(n,i+1,k,notEmptySetCount+1,ans);
                ans.get(j).remove(ans.get(j).size()-1);
                break;
            }
        }
    }
}
