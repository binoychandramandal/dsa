package recurrsion.practise;

import java.util.ArrayList;

public class PartitionInKSubset {
    static int counter=0;
    public static void main(String[] args) {
        int k=3;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(1,4,3,0,ans);

    }

    static void solution(int i, int n, int k, int countOfNonEmptySet, ArrayList<ArrayList<Integer>> ans){
        if(i>n){
            if(countOfNonEmptySet==k){
                counter++;
                System.out.print(counter+".");
                for(ArrayList<Integer> set: ans){
                    System.out.print(set+" ");
                }
                System.out.println();
            }
            return;
        }
        for (int j = 0; j < ans.size(); j++) {
            if(ans.get(j).size()>0){
                ans.get(j).add(i);
                solution(i+1,n,k,countOfNonEmptySet,ans);
                ans.get(j).remove(ans.get(j).size()-1);
            }else{
                ans.get(j).add(i);
                solution(i+1,n,k,countOfNonEmptySet+1,ans);
                ans.get(j).remove(ans.get(j).size()-1);
                break;
            }
        }
    }
}
